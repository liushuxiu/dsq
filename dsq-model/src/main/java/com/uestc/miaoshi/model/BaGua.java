package com.uestc.miaoshi.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BaGua {
    private String name;
    private int age;
}


