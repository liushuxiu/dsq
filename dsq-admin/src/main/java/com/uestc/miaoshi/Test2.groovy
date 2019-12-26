package com.uestc.miaoshi

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer
import com.uestc.miaoshi.exception.BizException
import com.uestc.miaoshi.exception.RefundException
import com.uestc.miaoshi.model.BillRepaymentExt
import com.uestc.miaoshi.model.Per
import com.wangwenjun.java8.Dish
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import javax.persistence.criteria.CriteriaBuilder
import javax.sound.midi.Soundbank
import java.sql.SQLOutput
import java.util.concurrent.ConcurrentMap
import java.util.logging.Level
import java.util.stream.Collectors

import static com.wangwenjun.java8.CollectorsAction.menu
import static java.util.stream.Collectors.averagingInt
import static java.util.stream.Collectors.toConcurrentMap

@Slf4j
@CompileStatic
class Test2 {

    public static void main(String[] args) {

    }


    public static void main3(String[] args) {
        List<Integer> ly = new ArrayList<>();
        ly.each {
            println it
        }
        Integer m = ly == null ? 0 : ly.sum() as int;
        println m
        int x = ly.sum() as int;
        println x
        ly.stream().forEach({ p -> System.out.println(p) })
        Map<Integer, Integer> map = null



        try {
            List<Integer> list = Arrays.asList(1,2,3,4,5,6)
            boolean any = list.any {it <7}
            boolean all = list.every { it >=7}
            println any != all
        } catch (RefundException e) {

        } catch (BizException e) {

        }

    }
    public static void main2(String[] args) {

        List<Integer> my = new ArrayList<>(Arrays.asList(1,2,3,4,5,6))


        Map<String, List<BillRepaymentExt>> billRepaymentExtMap = null
////        List<BillRepaymentExt> billRepaymentExtSubList = billRepaymentExtMap?.get("5", [])
        List<BillRepaymentExt> billRepaymentExtSubList = []
        def collect = billRepaymentExtSubList.collect { it.repaymentId }

        def join = my.max()


        List<Per> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Per per = new Per();
            if (i%3 == 0) {
                per.setName("a")
            } else if (i % 3 == 1) {
                per.setName("b")
            } else {
                per.setName("c")
            }


            per.setAge(i)
            per.setLevel( 1 + new Random().nextInt(3))
            list.add(per)
        }

        println list
        def max = list.max{it.age}
        println "max is:" + max


        println list.groupBy {it.name}

        List<String> collect2 = list.groupBy { it.name}.collect { String name, List<Per> pers ->
              int sum = pers.sum{it.age} as int
              int aver = sum / pers.size() as int
             return "key=" + name + " -> " + "value=" + aver
         }

        println collect.getClass()


        list.sort{
            a,b -> a.level < b.level ? -1 : a.level > b.level ? 1 : b.age - a.age
        }

        list.sort ({
            a, b ->
                 if (a.level < b.level) {
                     return -1;
                 } else if (a.level == b.level) {
                     return b.age.compareTo(a.age)
                 } else {
                     return 1
                 }

        })
        println list

        while (true) {

        }

        list.collate(10).each {
            try {
                println(it.collect{it.age})
            } catch (Exception e) {
                log.error("Create new collection order or move to cboss failed; orderIds: $it; message: ${e.message}", e)
            }
        }

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put("a" + i, "" + i)
        }
        println map


        Map<String, String> all = map.findAll {list.collect {it.name}.contains(it.key)}
        println all


        def collect1 = list.collect {it.age}
        println collect1





        list.stream().forEach({ p -> System.out.println(p); })
    }
}
