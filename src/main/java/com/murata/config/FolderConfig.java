package com.murata.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;


@Component("config")
@ConfigurationProperties(prefix="global")
@PropertySource(value="file:C:\\Programming\\Data\\config.properties")
@Getter@Setter@ToString@NoArgsConstructor
public class FolderConfig {

    //scan time in milliseconds
    private  String scanTime;
    private  String tempFolder;
    private  String vibFolder;

    public FolderConfig(String scanTime, String tempFolder, String vibFolder) {
        this.scanTime = scanTime;
        this.tempFolder = tempFolder;
        this.vibFolder = vibFolder;
    }

}
