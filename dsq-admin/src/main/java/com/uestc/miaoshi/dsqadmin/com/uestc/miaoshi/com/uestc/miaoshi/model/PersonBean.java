package com.uestc.miaoshi.dsqadmin.com.uestc.miaoshi.com.uestc.miaoshi.model;


import java.io.Serializable;

public class PersonBean implements Serializable {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
