package com.uestc.miaoshi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class TreeNode {
    int n, m;
   ArrayList< ArrayList<Integer>> res = new ArrayList<>();
    boolean addAll;
    TreeNode left, right, parent;
    public TreeNode(int n, int m, boolean addAll) {
        this.n = n;
        this.m = m;
        this.addAll = addAll;
    }
}
public class BreakNToM {
    static int allCount = 0;
    static HashMap<String , TreeNode> map = new HashMap<>();
//    static ArrayList<TreeNode> leafs = new ArrayList<>();
//    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            long start = System.currentTimeMillis();
            int n = in.nextInt();
//            int m = in.nextInt();
//            leafs.clear();
            map.clear();
//            result.clear();
            count = 0;
            for (int i = 1; i <=n; i++) {
                TreeNode root = f(n, i, true);
                System.out.println(root.res);
                count = count + root.res.size();

            }

            long end = System.currentTimeMillis();
            System.out.println("耗时秒数:" + (end - start)/1000);

//            System.out.println(result);
            System.out.println("所有组合总数"+count);
        }
    }
    private static String getKey(int m, int n, boolean flag) {
        return (n) + ":" +(m) + ":" + flag;
    }
//    private static void recursive(TreeNode leaf) {
//
//        if (leaf.parent == null) {
////            Collections.sort(leaf.res);
//            result.add(leaf.res);
//            return;
//        }
//        ArrayList<Integer> res = leaf.res;
//        if (leaf.addAll) {
//            ArrayList<Integer> temp = new ArrayList<>();
//            for (int x : res) {
//                temp.add(x + 1);
//            }
//            leaf.parent.res = temp;
//        } else {
//            res.add(1);
//            leaf.parent.res = res;
//        }
//        recursive(leaf.parent);
//    }

    static  ArrayList<Integer> addAll(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>(list);
        for (int i = 0; i < list.size(); i++) {
            res.add(1 + list.get(i));
        }
        return res;
    }

    static ArrayList<Integer> addOne(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>(list);
        res.add(1);
        return res;
    }

    static HashMap<Integer, ArrayList<Integer>> M_LIST = new HashMap<>();
    static HashMap<Integer, ArrayList<Integer>> ONE_LIST = new HashMap<>();

    static TreeNode f(int n, int m, boolean allAdd) {

        String key = getKey(m, n, allAdd);
        if (map.containsKey(key)) {
            return map.get(key);
        }
//        System.out.println("haha" + allCount++);
        if (n < m || n <= 0 || m <= 0) {
            map.put(key, null);
            return null;
        }
        TreeNode node = new TreeNode(n, m, allAdd);
        if (n == m) {
            TreeNode leaf = new TreeNode(n, n, allAdd);
            if (M_LIST.containsKey(m)) {
                leaf.res.add(M_LIST.get(m));
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = 0; i < m; i++) {
                    temp.add(1);
                }

                M_LIST.put(m, temp);
                leaf.res.add(temp);
            }

            map.put(key, leaf);
            return leaf;
        }
        if (m == 1) {
            TreeNode leaf = new TreeNode(n, 1, allAdd);
            if (ONE_LIST.containsKey(n)) {
                leaf.res.add(ONE_LIST.get(n));
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(n);
                leaf.res.add(temp);
                ONE_LIST.put(n, temp);
            }
            map.put(key, leaf);
            return leaf;
        }

        node.left = f(n - m, m, true);

        if (node.left != null) {
            node.left.parent = node;
            ArrayList<ArrayList<Integer>> leftRess = node.left.res;
            if (node.left.addAll) {
                for (ArrayList<Integer> leftRes : leftRess) {
                    ArrayList<Integer> integers = addAll(leftRes);
                    node.res.add(integers);
                }
            } else {
                for (ArrayList<Integer> leftRes : leftRess) {
                    ArrayList<Integer> integers = addOne(leftRes);
                    node.res.add(integers);
                }
            }
        }
        String leftKey = getKey(m, n - m, true);
        map.put(leftKey, node.left);
        node.right = f(n - 1, m - 1, false);

        if (node.right != null)  {
            node.right.parent = node;
            ArrayList<ArrayList<Integer>> rightRess = node.right.res;
            if (node.right.addAll) {
                for (ArrayList<Integer> rightRes : rightRess) {
                    ArrayList<Integer> integers = addAll(rightRes);
                    node.res.add(integers);
                }
            } else {
                for (ArrayList<Integer> rightRes : rightRess) {
                    ArrayList<Integer> integers = addOne(rightRes);
                    node.res.add(integers);
                }
            }
        }
        String rightKey = getKey(m - 1, n - 1,false);
        map.put(rightKey, node.right);
        map.put(key, node);
        return node;
    }}


