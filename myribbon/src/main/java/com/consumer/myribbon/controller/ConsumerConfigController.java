package com.consumer.myribbon.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 以这种方式注释的Bean可以在运行时刷新，
 并且使用它们的任何组件将在下一个方法调用上获得一个新实例，
 完全初始化所有依赖项。
 */
@RefreshScope
@RestController
public class ConsumerConfigController {

    //获取外部化配置 key 为hello的键值
    @Value("${hello}")
    private String hello;

    @Value("${ly}")
    private String ly;


    @GetMapping("/hello")
    public String configHelloWorld1() {
        System.out.println(ly);
        return this.hello;
    }
}
