package com.murata.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.rsocket.server")
@PropertySource(value="classpath:application.properties")
@Getter@Setter@ToString@NoArgsConstructor
public class ServerConfig {

    //TODO read & write to an external file

    private  String address;
    private  String port;

    public ServerConfig(String address,String port) {

        this.address=address;
        this.port=port;

    }
}
