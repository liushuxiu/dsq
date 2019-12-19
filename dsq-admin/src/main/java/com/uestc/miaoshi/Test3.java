package com.uestc.miaoshi;


import com.uestc.miaoshi.model.Per;
import com.wangwenjun.java8.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Test3 {

    public static void main(String[] args) {
        List<Per> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Per per = new Per();
            if (i%3 == 0) {
                per.setName("a");
            } else if (i % 3 == 1) {
                per.setName("b");
            } else {
                per.setName("c");
            }


            per.setAge(i);
            per.setLevel( 1 + new Random().nextInt(3));
            list.add(per);
        }

        System.out.println(list);



        ConcurrentMap<String, Per> collect = list.stream().collect(Collectors.toConcurrentMap(Per::getName, v -> v, (a, b) -> a.getLevel() > b.getLevel() ? a : b));
        System.out.println(collect);
    }
}


