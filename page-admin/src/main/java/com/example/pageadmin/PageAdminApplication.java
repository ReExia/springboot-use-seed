package com.example.pageadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.example.pageadmin.mapper")
public class PageAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(PageAdminApplication.class, args);
    }

}
