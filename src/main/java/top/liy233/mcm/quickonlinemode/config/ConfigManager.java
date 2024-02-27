package top.liy233.mcm.quickonlinemode.config;

import com.google.gson.Gson;
import top.liy233.mcm.quickonlinemode.Main;
import top.liy233.mcm.quickonlinemode.utils.FileUtil;

import java.io.*;

public class ConfigManager {
    public static ConfigData config;

    public static void parseData(){
        Gson gson = new Gson();
        String cfg = FileUtil.readFile(Main.CONFIG_FILE);
        if (cfg.length() == 0){
            FileUtil.writeFile(Main.CONFIG_FILE, SAMPLE_CONFIG);
        }
        config = gson.fromJson(cfg, ConfigData.class);
    }

    public static void checkConfig() throws IOException {
        if (!Main.ROOT_PATH.toFile().exists()){
            Main.ROOT_PATH.toFile().mkdir();
            Main.CONFIG_FILE.createNewFile();
            resetConfigFile();
            resetFrpcFile();
        }
        if (! Main.CONFIG_FILE.exists()){
            Main.CONFIG_FILE.createNewFile();
            resetConfigFile();
        }
    }

    private static void resetFrpcFile() {
        InputStream inputStream = ConfigManager.class.getResourceAsStream("/frpc/frpc.exe");
        if (inputStream != null){
            try (OutputStream outputStream = new FileOutputStream(Main.FRPC_FILE)) {
                byte[] buffer = new byte[10240];
                int len;
                while ((len = inputStream.read(buffer)) != -1){
                    outputStream.write(buffer, 0, len);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void resetConfigFile(){
        FileUtil.writeFile(Main.CONFIG_FILE, SAMPLE_CONFIG);
    }

    private static final String SAMPLE_CONFIG = """
            {
                "user": "你的用户名",
                "password": "密码",
                "key": "用户密钥"
            }
            """;

}
