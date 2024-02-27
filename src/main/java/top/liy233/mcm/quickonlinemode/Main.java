package top.liy233.mcm.quickonlinemode;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.liy233.mcm.quickonlinemode.commands.Command;
import top.liy233.mcm.quickonlinemode.config.ConfigManager;

import java.io.File;
import java.nio.file.Path;

public class Main implements ModInitializer {
	//
	public static final Logger LOGGER = LoggerFactory.getLogger("快速联机模组");
	public static final Path ROOT_PATH = FabricLoader.getInstance().getConfigDir().resolve("QuickOnlineMod");
	public static final File CONFIG_FILE = ROOT_PATH.resolve("config.json").toFile();
	public static final File FRPC_FILE = ROOT_PATH.resolve("frpc.exe").toFile();
	public static int SERVER_PORT = 0;
	public static String TOKEN = "";


	@Override
	public void onInitialize() {

		try {
			ConfigManager.checkConfig();
			ConfigManager.parseData();

			ServerEntityEvents.ENTITY_LOAD.register((PlayerEvent::join));

			Command.regCmd();

		} catch (Exception e){
			e.printStackTrace();
		}

		LOGGER.info("模组初始化成功");
	}
}
