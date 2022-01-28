package com.quyuanjin.imseveneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ImseveneurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImseveneurekaApplication.class, args);
    }

}
