package top.liy233.mcm.quickonlinemod.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import top.liy233.mcm.quickonlinemod.Main;
import top.liy233.mcm.quickonlinemod.config.ConfigManager;
import top.liy233.mcm.quickonlinemod.process.CheckUser;
import top.liy233.mcm.quickonlinemod.process.CreateChannel;

import static net.minecraft.server.command.CommandManager.*;


public class Command {
    public static CommandContext<ServerCommandSource> source;
    public static void regCmd(){
        // /quickonlinemod reset
        // /quickonlinemod start
        // /quickonlinemod start_channel <ChannelID>
        // /quickonlinemod help

        // TODO: 创建 /quickonlinemod start_channel <Channel_ID>
        // 1. 请求创建隧道
        // 2. 请求用户的隧道列表
        // 3. 找到刚创建的隧道
        // 4. 操控frpc，执行【frpc.exe -u <用户密钥> -p <隧道ID>】，并读取输出流
        // 5. 分析输出流，将开放的地址和ip使用tellraw打印出来
        // /tellraw @s {"text":"域名/IP", "color":"blue", "hoverEvent":{"action":"show_text","contents":"点击复制"}, "clickEvent":{"action":"copy_to_clipboard", "value":"域名/IP"}}

        // TODO: 创建 /quickonlinemod help
        // 打开帮助网页

        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(
                    literal("quickonlinemod").requires(s -> s.hasPermissionLevel(2))
                            .then(literal("reset").executes(context -> resetConfig()))
                            .then(literal("start").executes(context -> start(context)))
                            .then(literal("help").executes(context ->  help(context)))
                            .then(literal("start_channel")
                                            .then(argument("cid", IntegerArgumentType.integer()).executes(context -> startChannel(context)))
                            )
            );
        });
    }

    private static int startChannel(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        source = context;
        CreateChannel createChannel = new CreateChannel(context);
        createChannel.start();

        return 1;
    }

    private static int help(CommandContext<ServerCommandSource> context) {
        // 打开帮助网页
        return 1;
    }

    private static int start(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        Main.LOGGER.info("Port:" + Main.SERVER_PORT);
        source = context;

        CheckUser mainProcess = new CheckUser(context.getSource().getPlayer(), context.getSource());
        mainProcess.start();

        return 1;
    }

    public static int resetConfig(){
        ConfigManager.resetConfigFile();
        return 1;
    }

    public static void exec(String command) throws CommandSyntaxException {
        source.getSource().getPlayer().server.getCommandManager().execute(source.getSource(), command);
    }


}
