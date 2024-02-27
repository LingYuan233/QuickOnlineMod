package top.liy233.mcm.quickonlinemod.process;

import com.google.gson.Gson;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.liy233.mcm.quickonlinemod.Main;
import top.liy233.mcm.quickonlinemod.config.ConfigData;
import top.liy233.mcm.quickonlinemod.config.ConfigManager;
import top.liy233.mcm.quickonlinemod.utils.HttpRequestUtil;
import top.liy233.mcm.quickonlinemod.utils.data.*;

import java.net.HttpURLConnection;
import java.util.ArrayList;

public class CheckUser extends Thread {
    private Logger logger;
    private ConfigData config;
    private Gson gson;
    private ServerPlayerEntity player;
    private ServerCommandSource source;
    public static ArrayList<GetChannelsResultData.ChannelData> channels;

    public CheckUser(ServerPlayerEntity player_, ServerCommandSource source_){
        setName("检查用户");
        logger = LoggerFactory.getLogger("QOM - Process");
        config = ConfigManager.config;
        gson = new Gson();
        player = player_;
        source = source_;
    }

    @Override
    public void run() {

        try {
            // 登陆
            send("正在登陆...");
            boolean status = HttpRequestUtil.login(new LoginRequestData(config.getUser(), config.getPassword()));

            if (! status){
                send("登陆失败，请报告此错误");
                return;
            }
            // 删除其他以QOM_开头的隧道
            HttpURLConnection rmQOMChannel = HttpRequestUtil.sendWithToken("POST", URLs.GET_USER_CHANNELS, null);
            GetUserChannelsResultData rmQOMChannelD = HttpRequestUtil.parse(rmQOMChannel, GetUserChannelsResultData.class);
            for (GetUserChannelsResultData.Data.Channel channel : rmQOMChannelD.getData().getList()){
                if (channel.getProxyName().startsWith("QOM_")){
                    //删除此隧道
                    DeleteChannelRequestData data = new DeleteChannelRequestData(channel.getId());
                    Main.LOGGER.info("删除隧道：{}，ID：{}", channel.getProxyName(), channel.getId());
                    HttpURLConnection c = HttpRequestUtil.sendWithToken("POST", URLs.DELETE_CHANNEL, gson.toJson(data));
                    DeleteChannelResultData d = HttpRequestUtil.parse(c, DeleteChannelResultData.class);
                    Main.LOGGER.info(gson.toJson(d));
                }
            }

            send("登陆成功，正在获取隧道信息");
            //
            HttpURLConnection getUserInfo = HttpRequestUtil.sendWithToken("POST", URLs.GET_USER_INFO, null);
            GetUserResultData userInfo = HttpRequestUtil.parse(getUserInfo, GetUserResultData.class);
            int maxChannels = userInfo.getData().getProxies();
            int usedChannels = userInfo.getData().getUsed();
            Main.LOGGER.info("最多可用:{} 已用:{}", maxChannels, usedChannels);
            getUserInfo.disconnect();

            if (maxChannels <= usedChannels){
                send("没有隧道余额");
                return;
            }

            send("正在加载隧道信息");
            HttpURLConnection getNodes = HttpRequestUtil.sendWithToken("POST", URLs.GET_NODE_LIST, null);
            GetChannelsResultData allNodes = HttpRequestUtil.parse(getNodes, GetChannelsResultData.class);
            Main.LOGGER.info("所有隧道总数: {}",allNodes.getData().getTotal());
            channels = new ArrayList<>();
            for (GetChannelsResultData.ChannelData data : allNodes.getData().getList()){
                if (
                        data.getClassify() == 1 && // 国内
                        HttpRequestUtil.isUrl(data.getHostname()) && // 域名可见
                        ! data.isFullyLoaded() && // 非满载
                        data.getProtocolSupport().isTcp() && //TCP可用
                        data.getStatus() == 200 //在线
                ){
                    channels.add(data);
                }
            }
            Main.LOGGER.info("可用隧道总数: {}", channels.size());
            for (GetChannelsResultData.ChannelData data : channels){
//                Main.LOGGER.info("节点范围：{}", data.getAllowPort());
                StringBuilder b = new StringBuilder();
                int _id = data.getId();
                String id = _id < 10 ? "0"+_id : String.valueOf(_id);
                b.append("[").append(id).append("]").append("    ");
                b.append( String.format("%-10s", data.getName()));
                b.append(data.getBandwidth()*data.getBandwidthMagnification()).append("Mbps");
//                send(b.toString());

                String cmd = String.format(TEMPLATE, b, _id, _id);
                player.server.getCommandManager().execute(source, cmd);
//                Main.LOGGER.info(cmd);

            }


        } catch (Exception e){
            player.sendMessage(Text.of("登陆失败："+e.getMessage()), true);
            e.printStackTrace();
        }
    }

    private void send(String msg){
        player.sendMessage(Text.of(msg), false);
    }

    private static final String TEMPLATE = """
            /tellraw @p {"text": "%s","color": "blue","hoverEvent": {"action":"show_text","contents":"点击此处在此创建联机隧道(%s号)"},"clickEvent":{"action":"run_command","value":"/_qom %d"}}
            """;
}
