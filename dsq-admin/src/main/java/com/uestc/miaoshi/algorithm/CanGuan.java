package com.uestc.miaoshi;

import java.util.Scanner;

/**
 * 思路，用动态规划可解决此类问题
 * <p>
 * 下面我就假设 n =3,m=5来分析
 * <p>
 * 每次来一批人的时候，我们就试着把人安排在三桌的某一桌
 * <p>
 * 1.  当人数大于三张桌子的任何一张的容量是，忽略这一批人，因为坐不下啊。。。。。
 * <p>
 * 2.  把人分别安排在三张桌子，看看那种情况下增加的利润值最大，就选择那一桌。比如说第一批人给的钱没第五批人钱多，很明显要被置换掉。比较完后，记录下是哪一张桌子然后把该桌子拥有的利润值更新
 */
public class CanGuan {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int v[][] = new int[3][n];
            for (int i = 0; i < n; i++) {
                v[0][i] = in.nextInt();
            }
            int p[][] = new int[m][2];
            for (int i = 0; i < p.length; i++) {
                p[i][0] = in.nextInt();
                p[i][1] = in.nextInt();
            }
            for (int i = 0; i < m; i++) {
                int increase = 0;
                int maxIndex = -1;
                for (int j = 0; j < n; j++) {
                    int add = 0;
                    if (p[i][0] > v[0][j]) {
                        continue;
                    }
                    if (p[i][1] > v[2][j]) {
                        add = p[i][1] - v[2][j];
                    }
                    if (add > increase) {
                        increase = add;
                        maxIndex = j;
                    }
                }
                if (maxIndex != -1) {
                    v[2][maxIndex] = p[i][1];
                }
            }
            int res = 0;
            for (Integer i : v[2]) {
                System.out.println(i);
                res += i;
            }
            System.out.println(res);
        }
    }
}