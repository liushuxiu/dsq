package com.uestc.miaoshi.model

import groovy.transform.CompileStatic
import org.hibernate.validator.constraints.NotBlank
import org.hibernate.validator.constraints.NotEmpty


@CompileStatic
class Per {

     int age;

     String name

     int level


     @Override
     public String toString() {
          return "Per{" +
                  "age=" + age +
                  ", name='" + name + '\'' +
                  ", level=" + level +
                  '}';
     }
}
