package com.register.springcloudtestregister.controller;


import com.uestc.miaoshi.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;

public class HelloWorld {

    @RequestMapping("/")
    public void hello() {
        System.out.println("haha");
    }
}


