package top.liy233.mcm.quickonlinemod.utils;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import top.liy233.mcm.quickonlinemod.Main;
import top.liy233.mcm.quickonlinemod.commands.Command;
import top.liy233.mcm.quickonlinemod.config.ConfigData;
import top.liy233.mcm.quickonlinemod.config.ConfigManager;
import top.liy233.mcm.quickonlinemod.utils.data.GetUserChannelsResultData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FrpcUtil extends Thread {

    private ConfigData config;
    private int cid;
    private String command;
    private BufferedReader reader;
    private ServerPlayerEntity player;
    private GetUserChannelsResultData.Data.Channel c;
    private String TEMPLATE = "/tellraw @s {\"text\":\"%s\", \"underlined\":true, \"color\":\"blue\", \"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"点击复制\"}, \"clickEvent\":{\"action\":\"copy_to_clipboard\", \"value\":\"%s\"}}";


    public FrpcUtil(GetUserChannelsResultData.Data.Channel channel, String command, ServerPlayerEntity player){
        config = ConfigManager.config;
        this.cid = channel.getId();
        this.c = channel;
        this.player = player;
        this.command = command;
    }

    public void run() {
        try {
            Process process = Runtime.getRuntime().exec(this.command);
            reader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));

            String line;
            while ((line = reader.readLine()) != null){
                Main.LOGGER.info(line);
//
                if (line.contains("启动成功")){
                    Command.exec(String.format(TEMPLATE, "联机地址（点击复制）："+c.getConnectAddress(), c.getConnectAddress()));
                }
                else if (line.contains("启动失败")){
                    player.sendMessage(Text.of("启动失败，请重试或检查网络环境"), false);
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CommandSyntaxException e) {


        }
    }
}
