package top.liy233.mcm.quickonlinemode;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.registry.CommandRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.command.CommandSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.liy233.mcm.quickonlinemode.commands.Command;
import top.liy233.mcm.quickonlinemode.config.ConfigManager;

import java.io.File;
import java.nio.file.Path;

public class Client implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("快速联机模组");

    public static final Path ROOT_PATH = FabricLoader.getInstance().getConfigDir().resolve("QuickOnlineMod");
    public static final File CONFIG_FILE = ROOT_PATH.resolve("config.json").toFile();
    public static int SERVER_PORT = 0;
    public static String TOKEN = "";
    public static String LOGIN_COOKIE;


    @Override
    public void onInitializeClient() {

        try {
            ConfigManager.checkConfig();
            ConfigManager.parseData();

        } catch (Exception e){
            e.printStackTrace();
        }

        LOGGER.info("模组初始化成功");
    }
}
