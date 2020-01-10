package com.uestc.miaoshi.dsqadmin;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private int id;
    private String name;
    private int sex;    // 0=male, 1=female
    private String addr;



    public Student(int id, String name, int sex, String addr) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.addr = addr;
    }

    public Student(String name, int sex, String addr) {
        this.name = name;
        this.sex = sex;
        this.addr = addr;
    }
}
