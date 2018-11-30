package com.cerebro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.cerebro" })
public class CerebroApp {

    public static void main(String[] args) {
	SpringApplication.run(CerebroApp.class, args);
    }
}
