package com.example.writereadmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class
        }
)
@MapperScan(basePackages = {"com.example.writereadmysql.mapper"})
public class WriteReadMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(WriteReadMysqlApplication.class, args);
    }

}
