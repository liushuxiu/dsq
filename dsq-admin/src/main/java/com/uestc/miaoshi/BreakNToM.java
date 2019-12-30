package com.uestc.miaoshi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class TreeNode {
    int n, m;
    ArrayList<Integer> res = new ArrayList<>();
    boolean addAll;
    TreeNode left, right, parent;

    public TreeNode(int n, int m, boolean addAll) {
        this.n = n;
        this.m = m;
        this.addAll = addAll;
    }
}


public class BreakNToM {

    static ArrayList<TreeNode> leafs = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            leafs.clear();
            f(n, m, true);

            for (TreeNode leaf : leafs) {
                recursive(leaf);
            }

            Collections.sort(result, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return recursiveCom(0, o1, o2);
                }

                private int recursiveCom(int i, ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    int sub = o1.get(i) - o2.get(i);
                    if (sub == 0 ) {
                        return recursiveCom(i + 1, o1, o2);
                    }
                    return  sub;
                }
            });

            System.out.println(result);
        }

    }

    private static void recursive(TreeNode leaf) {
        if (leaf.parent == null) {
            Collections.sort(leaf.res);
            result.add(leaf.res);
            return;
        }
        ArrayList<Integer> res = leaf.res;
        if (leaf.addAll) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int x : res) {
                temp.add(x + 1);
            }
            leaf.parent.res = temp;
        } else {
            res.add(1);
            leaf.parent.res = res;
        }
        recursive(leaf.parent);
    }

    static TreeNode f(int n, int m, boolean allAdd) {
        if (n < m || n <= 0 || m <= 0) {
            return null;
        }
        TreeNode node = new TreeNode(n, m, allAdd);
        if (n == m) {
            TreeNode leaf = new TreeNode(n, n, allAdd);
            for (int i = 0; i < m; i++) {
                leaf.res.add(1);
            }
            leafs.add(leaf);
            return leaf;
        }
        if (m == 1) {
            TreeNode leaf = new TreeNode(n, 1, allAdd);
            leaf.res.add(n);
            leafs.add(leaf);
            return leaf;
        }

        node.left = f(n - m, m, true);
        if (node.left != null)
            node.left.parent = node;
        node.right = f(n - 1, m - 1, false);
        if (node.right != null)
            node.right.parent = node;
        return node;
    }
}


