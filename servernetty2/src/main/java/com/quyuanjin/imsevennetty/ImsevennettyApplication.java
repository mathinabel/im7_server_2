package com.quyuanjin.imsevennetty;

import com.quyuanjin.imsevennetty.chat.ChatMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ImsevennettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImsevennettyApplication.class, args);
        new ChatMain().start(8089);
    }

}
