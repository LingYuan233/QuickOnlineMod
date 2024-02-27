package top.liy233.mcm.quickonlinemode;

import com.google.gson.Gson;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import top.liy233.mcm.quickonlinemode.process.URLs;
import top.liy233.mcm.quickonlinemode.utils.HttpRequestUtil;
import top.liy233.mcm.quickonlinemode.utils.data.DeleteChannelRequestData;
import top.liy233.mcm.quickonlinemode.utils.data.DeleteChannelResultData;
import top.liy233.mcm.quickonlinemode.utils.data.GetUserChannelsResultData;

import java.io.IOException;
import java.net.HttpURLConnection;

public class Events {

    public static ActionResult join(Entity entity, ServerWorld world){
        if (entity.isPlayer() && !Main.TIP_PLAYER){
            PlayerEntity player = (PlayerEntity) entity;
            player.sendMessage(Text.of("[QOM] 此模组基于OpenFRP的OPEN API"), false);
            player.sendMessage(Text.of("[QOM] 使用/quickonlinemod start进行联机"), false);
            Main.TIP_PLAYER = true;
        }
        return ActionResult.PASS;
    }


    public static void stoped(MinecraftServer minecraftServer) {
        // 关闭时，结束所有frpc.exe进程
        try {
            Gson gson = new Gson();
            ProcessBuilder processB = new ProcessBuilder("taskkill", "/F", "/IM", "frpc.exe");
            Process p = processB.start();
            int s = p.waitFor();
            if (s == 0){
                //删除隧道
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
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
