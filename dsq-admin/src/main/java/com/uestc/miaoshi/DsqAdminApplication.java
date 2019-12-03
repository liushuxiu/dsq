package com.uestc.miaoshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.uestc.miaoshi")
public class DsqAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsqAdminApplication.class, args);
    }

}
