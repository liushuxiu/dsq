package com.uestc.miaoshi;

import java.util.ArrayList;
import java.util.Scanner;
public class BreakN2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            long start = System.currentTimeMillis();
            int n = in.nextInt();
            count = 0;
            recursive(1, 0 , n);
            System.out.println("所有组合总数" + count);
            long end = System.currentTimeMillis();
            System.out.println( (end - start)/1000);
        }
    }

   static int count = 0;
   static ArrayList<Integer> list = new ArrayList<>();
   static void recursive(int last, int curSum, int n) {
        if (last + curSum > n) return;

        for (int i = last; i <= n ; i++) {
            curSum = curSum + i;
            list.add(i);
            if (curSum == n) {
                count ++;
//                System.out.println(list);
            }
            recursive(i, curSum, n);
            curSum = curSum - i;
            Integer o = i;
            list.remove(o);
        }
    }
}


