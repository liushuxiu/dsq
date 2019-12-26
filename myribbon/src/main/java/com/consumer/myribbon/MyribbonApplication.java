package com.consumer.myribbon;

import com.consumer.myribbon.feign.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(clients = StudentService.class) //指定API开启
public class MyribbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyribbonApplication.class, args);
    }

    @Bean
    //负载均衡注解
//    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
