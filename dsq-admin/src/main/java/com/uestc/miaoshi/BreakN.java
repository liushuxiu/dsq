package com.uestc.miaoshi;

import java.util.HashMap;
import java.util.Scanner;
public class BreakN {
    static int allCount = 0;
    static HashMap<String , Long> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            long start = System.currentTimeMillis();
            long res = 0;
           int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                res = res + f(n, i);
            }
            System.out.println("总共组合数: " + res);
            long end = System.currentTimeMillis();
            System.out.println("耗时秒数:"+ (end - start)/1000);
        }
    }
    /**
     * 函数功能，把正整数 n 分成 m 等份  4 = 1+3 = 2+2
     * @param n
     * @param m
     *  f(n) = f(n-m, m) + f(n-1, m-1)
     */
    private static long f(int n, int m) {

        if (map.containsKey(m + ":" + n)) {
            return map.get(m + ":" + n);
        }
        System.out.println("haha" + allCount++);
        if ( n <=0 || m <= 0 || n < m) {
            map.put(m + ":" + n, (long) 0);
            return 0;
        }
        if (m == 1 || m == n) {
            map.put(m + ":" + n, (long) 1);
            return 1;
        }
        long a = f(n - m, m) ;
         long b =  f(n-1, m-1);
         map.put(m + "" + (n-m) ,a);
         map.put((m-1) +":" + (n-1), b);
         map.put(m + ":" + n, a+ b);
         return a + b;
    }
}


