package com.murata.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Properties;

@Component
@Getter@Setter
public class UpdateConfig {

    private static File file;
    private static Properties properties;
    private static Resource resource ;


    public static void write(FolderConfig config) {
        try {
            file = new File("C:\\Programming\\Data\\config.properties");
            FileInputStream in = new FileInputStream(file);
            properties = new Properties();
            properties.load(in);

            properties.setProperty("global.vibFolder", config.getVibFolder());
            properties.setProperty("global.tempFolder", config.getTempFolder());
            properties.setProperty("global.scanTime", config.getScanTime());

            FileOutputStream out = new FileOutputStream(file);
            properties.store(out, "Last Update");
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
