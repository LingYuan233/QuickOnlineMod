package top.liy233.mcm.quickonlinemod.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileUtil {
    public static String readFile(File file){
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = reader.readLine()) != null){
                buffer.append(text).append(System.getProperty("line.separator"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static void writeFile(File target, String text){
        try {
            if (!target.exists()){
                target.createNewFile();
            }
            FileWriter writer = new FileWriter(target);
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
