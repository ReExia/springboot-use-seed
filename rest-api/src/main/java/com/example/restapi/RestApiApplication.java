package com.example.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.example.restapi.mapper")
public class RestApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RestApiApplication.class, args);
    }

}
