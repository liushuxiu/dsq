package com.wangwenjun.java8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    static class Food {}
    static class Fruit extends Food {}
    static class Apple extends Fruit {}

    public static void main(String[] args) throws IOException {
        List<? extends Fruit> fruits = new ArrayList<>();
//        fruits.add(new Food());     // compile error
//        fruits.add(new Fruit());    // compile error
//        fruits.add(new Apple());    // compile error

        fruits = new ArrayList<Fruit>(); // compile success
        fruits = new ArrayList<Apple>(); // compile success
//        fruits = new ArrayList<Food>(); // compile error
//        fruits = new ArrayList<? extends Fruit>(); // compile error: 通配符类型无法实例化

        Fruit object = fruits.get(0);    // compile success
        
        //================
        List<? super Fruit> fruits2 = new ArrayList<>();
//        fruits2.add(new Food());     // compile error
        fruits2.add(new Fruit());    // compile success
        fruits2.add(new Apple());    // compile success

        fruits2 = new ArrayList<Fruit>(); // compile success
//        fruits2 = new ArrayList<Apple>(); // compile error
        fruits2 = new ArrayList<Food>(); // compile success
//        fruits2 = new ArrayList<? super Fruit>(); // compile error: 通配符类型无法实例化

//        Fruit object = fruits2.get(0); // compile error
    }
}