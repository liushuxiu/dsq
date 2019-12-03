package com.uestc.miaoshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = "com.uestc.miaoshi.*")
@EnableTransactionManagement
public class DsqAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsqAdminApplication.class, args);
    }

}
