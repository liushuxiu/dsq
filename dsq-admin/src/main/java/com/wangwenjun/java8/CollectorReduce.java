package com.wangwenjun.java8;

import javax.persistence.criteria.CollectionJoin;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/***************************************
 * @author:Alex Wang
 * @Date:2016/10/27 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class CollectorReduce {
    public static void main(String[] args) {

        ArrayList list2  = new ArrayList(Arrays.asList("1", "2","3"));
        Object collect3 = list2.stream().collect(joining(":"));
        System.out.println(collect3);
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        long count = menu.stream().filter(d -> d.isVegetarian()).count();

        Long collect = menu.stream().filter(d -> d.isVegetarian()).collect(Collectors.counting());

//        Optional<Integer> maxCalories = menu.stream().map(Dish::getCalories).reduce(Integer::max);
        Optional<Dish> maxCalories = menu.stream().reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2);
        maxCalories.ifPresent(System.out::println);

        Optional<Dish> maxCaloriesCollect = menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)));
        maxCaloriesCollect.ifPresent(System.out::println);


        Integer collect11 = menu.stream().collect(Collectors.collectingAndThen(toList(), t -> t.size()));
        System.out.println(collect11);


        Map<Dish.Type, List<Dish>> collect22 = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(collect22);

        Map<Dish.Type, Double> collect33 = menu.stream().collect(groupingBy(Dish::getType, averagingInt(Dish::getCalories)));
        System.err.println(collect33);

        String str= Stream.of("a", "b", "c").collect(collectingAndThen(joining(","), x -> x + "d"));
        System.out.println(str);

        List<Integer> list = Arrays.asList(1, 2, 3);
        // {key1=value:10, key2=value:20, key3=value:30}  {key1=value:1 , key2=value:2 , key3=value:3 }
        // toMap 可用于将List转为Map，便于通过key快速查找到某个value
        Map<String, String> collect1 = list.stream().map(i -> i * 10).collect(Collectors.toMap(key -> "key" + key/10, value -> "value:" + (value -6)));
        Map<String, String> collect2 = list.stream().collect(Collectors.toMap(key -> "key" + key, value -> "value:" + value));

        System.out.println(collect1.toString());
        System.out.println(collect2.toString());



    }
}
