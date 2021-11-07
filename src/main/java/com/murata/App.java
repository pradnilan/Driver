package com.murata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EntityScan("com.murata")
//@EnableJpaRepositories("com.murata.repository")
public class App {

   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(App.class);



       /* Initialize init=new Initialize();
        System.out.println(init.getFolderPath());*/

    }
    
}
