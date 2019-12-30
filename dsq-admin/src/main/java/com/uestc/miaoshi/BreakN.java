package com.uestc.miaoshi;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BreakN {


    public static void main(String[] args) {
        int m = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println(f(9,3));

        while (sc.hasNextInt()) {
            int res = 0;
           int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                res = res + f(n, i);
            }
            System.out.println("all res: " + res);
        }

    }

    /**
     * 函数功能，把正整数 n 分成 m 等份  4 = 1+3 = 2+2
     * @param n
     * @param m
     *  f(n) = f(n-m, m) + f(n-1, m-1)
     */
    private static int f(int n, int m) {
        if ( n <=0 || m <= 0 || n < m) {
            return 0;
        }

        if (m == 1) return 1;
        return f(n - m, m) + f(n-1, m-1);

    }
}


