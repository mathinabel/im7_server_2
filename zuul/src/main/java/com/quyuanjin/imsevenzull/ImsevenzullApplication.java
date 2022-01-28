package com.quyuanjin.imsevenzull;

import com.quyuanjin.imsevenzull.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ImsevenzullApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImsevenzullApplication.class, args);
    }

    @Bean
    public AccessFilter filter() {
        return new AccessFilter();
    }
}
