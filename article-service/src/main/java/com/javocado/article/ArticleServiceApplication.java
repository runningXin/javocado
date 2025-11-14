package com.javocado.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.javocado.article")
public class ArticleServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleServiceApplication.class, args);
    }
}