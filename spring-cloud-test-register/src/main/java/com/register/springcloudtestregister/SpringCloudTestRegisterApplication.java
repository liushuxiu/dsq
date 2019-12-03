package com.register.springcloudtestregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudTestRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTestRegisterApplication.class, args);
    }

}
