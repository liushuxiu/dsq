package com.uestc.miaoshi.leetcode.dp;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 *
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 *
 *     选出任一 x，满足 0 < x < N 且 N % x == 0 。
 *     用 N - x 替换黑板上的数字 N 。
 *
 * 如果玩家无法执行这些操作，就会输掉游戏。
 *
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 *
 *
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 *
 * 示例 2：
 *
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divisor-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class 除数博弈 {
   static HashMap<Integer, Boolean> map = new HashMap<>();

    public static boolean divisorGame(int N) {
        if ( map.get(N) != null && map.get(N) == true) {
            return map.get(N);
        }
        for (int i = 1; i < N; i++) {
            if (N % i == 0) {
                boolean res = divisorGame(N - i);
                if (map.get(N-i) == null) {
                     map.put(N-i, res);
                }
                return !res;
            }
        }
       return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            boolean res = divisorGame(N);
            System.out.println(res);
        }
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int dp = 0;
        for(int x : nums) {
            dp=Math.max(dp+x, x);
            max =Math.max(max,dp);
        }
        return max;

    }
    public int rob(int[] nums) {
       int res = recursive(nums, nums.length - 1);
       return res;
    }

    private int recursive(int[] nums, int i) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(nums[i]+recursive(nums,i-2), recursive(nums,i-1));
    }

    public boolean isSubsequence(String s, String t) {
        char sArr[] = s.toCharArray();
        char tArr[] = t.toCharArray();

        boolean dp[][] = new boolean[s.length() + 1][ t.length() +1];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (sArr[i] == tArr[j]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return false;

    }

}


