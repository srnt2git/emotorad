package com.emotorad.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableCaching
public class EmotoradServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(EmotoradServiceMain.class);
    }
}
