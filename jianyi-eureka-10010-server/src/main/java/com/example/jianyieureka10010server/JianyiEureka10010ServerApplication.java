package com.example.jianyieureka10010server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JianyiEureka10010ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JianyiEureka10010ServerApplication.class, args);
    }

}
