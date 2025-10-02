package com.javocado.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PortalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortalServiceApplication.class, args);
    }

    // ✅ 定义 RestTemplate Bean，用于 HTTP 调用
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}