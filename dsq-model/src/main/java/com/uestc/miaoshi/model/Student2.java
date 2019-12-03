package com.uestc.miaoshi.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @ClassName Student
 * @Description DTO
 * @Author Neal
 * @Date 2019/4/29 14:40
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class Student2 {
    private String name;
    private String id;
    private String card;
    private long phoneNumber;
    private String address;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
