package com.wangwenjun.java8;

public class RedApple extends Apple {
    Apple apple;
    public RedApple (Apple apple){
        this.apple = apple;
        System.out.println("my parent is " + apple.getColor() + " "+ apple.getWeight());
    }

    @Override
    public String toString() {
        return "RedApple{" +
                "apple=" + apple +
                '}';
    }
}
