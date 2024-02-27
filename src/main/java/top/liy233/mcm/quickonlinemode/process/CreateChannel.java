package top.liy233.mcm.quickonlinemode.process;

import com.google.gson.Gson;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import top.liy233.mcm.quickonlinemode.Main;
import top.liy233.mcm.quickonlinemode.config.ConfigData;
import top.liy233.mcm.quickonlinemode.config.ConfigManager;
import top.liy233.mcm.quickonlinemode.exception.RemotePortException;
import top.liy233.mcm.quickonlinemode.utils.FrpcUtil;
import top.liy233.mcm.quickonlinemode.utils.HttpRequestUtil;
import top.liy233.mcm.quickonlinemode.utils.data.CreateChannelRequestData;
import top.liy233.mcm.quickonlinemode.utils.data.CreateChannelResultData;
import top.liy233.mcm.quickonlinemode.utils.data.GetChannelsResultData;
import top.liy233.mcm.quickonlinemode.utils.data.GetUserChannelsResultData;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CreateChannel extends Thread{

    private ConfigData config;
    private int nodeID;
    private CommandContext<ServerCommandSource> source;
    private Gson gson;
    private int port;
    private ServerPlayerEntity player;
    private ArrayList<GetChannelsResultData.ChannelData> channelData;

    public CreateChannel(CommandContext<ServerCommandSource> source) throws CommandSyntaxException {
        setName("创建隧道");
        Main.LOGGER.info("构建...");
        this.port = Main.SERVER_PORT;
        this.nodeID = IntegerArgumentType.getInteger(source, "cid");
        this.player = source.getSource().getPlayer();
        this.source = source;
        this.gson = new Gson();
        this.config = ConfigManager.config;
        channelData = CheckUser.channels;
        Main.LOGGER.info("构建完成，节点ID：{}， 端口号：{}", nodeID, port);
    }

    @Override
    public void run() {
        // 线程主入口
        // 1. 根据传入的隧道id，构建请求对象
        // 2. 请求创建隧道API
        // 3. 请求用户隧道列表API，并解析成对象
        // 4. 遍历隧道列表，选出时间戳最近的一条隧道，保存隧道id
        // 5. cmd /c (frpc.exe -u <用户密钥> -p <隧道ID>)
        // 6. 读取输出流，发送给玩家
        try {
            // 根据传入的隧道ID，构建请求对象
            send("正在新建隧道，请稍后");
            GetChannelsResultData.ChannelData targetChannel = null;
            for (GetChannelsResultData.ChannelData data : channelData){
                if (data.getId() == this.nodeID){
                    targetChannel = data;
                    break;
                }
            }
            int remotePort = getRemotePort(targetChannel.getAllowPort());
            CreateChannelRequestData createChannelRequestData = CreateChannelRequestData.create(nodeID, port, remotePort);
            String createChannel = gson.toJson(createChannelRequestData);
            HttpURLConnection conn = HttpRequestUtil.sendWithToken("POST", URLs.CREATE_CHANNEL, createChannel);
            CreateChannelResultData createResult = HttpRequestUtil.parse(conn, CreateChannelResultData.class);
            Main.LOGGER.info("状态：{}", gson.toJson(createResult));
            if (! createResult.isFlag()){
                throw new RemotePortException(createResult.getMsg());
            }

            // 获取用户的隧道列表，比较时间戳，取最新的
            HttpURLConnection getUserChannels = HttpRequestUtil.sendWithToken("POST", URLs.GET_USER_CHANNELS, null);
            GetUserChannelsResultData userChannels = HttpRequestUtil.parse(getUserChannels, GetUserChannelsResultData.class);
            GetUserChannelsResultData.Data.Channel target = parseUserChannels(userChannels);
            Main.LOGGER.info("被选中的隧道：{}", target.getProxyName());
            send("正在启动该隧道，请留意信息");

            // 控制frpc完成隧道的启动
            // frpc.exe -u TOKEN -p CHANNEL_ID  -n
            String cmd = String.format("cmd /c (%s -u %s -p %s -n)", Main.FRPC_FILE.getAbsolutePath(), config.getKey(), target.getId());
            Main.LOGGER.info("命令行：{}", cmd);
            FrpcUtil frpc = new FrpcUtil(target, cmd, player);
            frpc.start();

            // 再次请求用户隧道列表，查验是否完全启动成功





        } catch (IOException e) {
            player.sendMessage(Text.of("创建失败，请重试"), false);
            e.printStackTrace();
        } catch (RemotePortException e) {
            player.sendMessage(Text.of(e.getMessage()) ,false);
        } catch (NullPointerException e){
            send("发生错误，请检查网络环境后重试");
        }
    }

    private GetUserChannelsResultData.Data.Channel parseUserChannels(GetUserChannelsResultData data){
        GetUserChannelsResultData.Data.Channel[] list = data.getData().getList();
        double last = 0.0;
        GetUserChannelsResultData.Data.Channel targetChannel = null;
        for (GetUserChannelsResultData.Data.Channel channel : list) {
            if (channel.getLastUpdate() >= last) {
                last = channel.getLastUpdate();
                targetChannel = channel;
            }
        }
        return targetChannel;
    }

    private int getRemotePort(Object con){
        String co = String.valueOf(con);
        if (co == null || co.length()==0){
            co = "(30000,60000)";
        }
        String range = co.replace(" ", "");
        range = range.substring(1, range.length()-1);
        Main.LOGGER.info(range);
        String[] b = range.split(",");
        Main.LOGGER.info(Arrays.toString(b));
        int l = Integer.parseInt(b[0]);
        int u = Integer.parseInt(b[1]);

        Random random = new Random();
        return random.nextInt(u-l+1)+l;
    }

    private void send(String msg){
        player.sendMessage(Text.of(msg), false);
    }
}
