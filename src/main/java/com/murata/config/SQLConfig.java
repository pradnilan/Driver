package com.murata.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:application.properties")
@ConfigurationProperties(prefix = "spring.datasource")
@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
public class SQLConfig {

    private String url;
    private String username;
    private String password;

}
