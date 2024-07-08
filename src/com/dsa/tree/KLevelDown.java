package com.dsa.tree;

import java.util.Scanner;

public class KLevelDown {

    public static void main(String[] args) {
        //Sample ==> 1 2 4 8 150 -1 -1 -1 9 -1 -1 5 10 30 70 -1 -1 80 -1 -1 10 90 -1 -1 -1 20 50 100 -1 -1 110 -1 -1 60 -1 -1 3 6 -1 -1 7 -1 -1
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode().construct(sc);
        int k = 3;
        int target = 5;
        findTarget(root, target, k);
    }

    private static void findTarget(TreeNode root, int target, int k) {
        if (root == null)
            return;
        if (root.val == target) {
            kLevelDown(root, k);
            return;
        }

        findTarget(root.left, target, k);
        findTarget(root.right, target, k);
    }

    private static void kLevelDown(TreeNode root, int k) {
        if (root == null)
            return;
        if (k == 0) {
            System.out.print(root.val + " ");
        }

        kLevelDown(root.left, k - 1);
        kLevelDown(root.right, k - 1);
    }
}
