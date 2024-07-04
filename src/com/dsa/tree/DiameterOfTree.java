package com.dsa.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class DiameterOfTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode().construct(sc);
        int diameter = findDiameter(root);
        System.out.println(diameter);
    }

    private static int findDiameter(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int maxWidth = Integer.MIN_VALUE;
        while (q.size() > 0) {
            int currentWidth = q.size();
            maxWidth = Math.max(maxWidth, currentWidth);
            for (int i = 0; i < currentWidth; i++) {
                TreeNode rm = q.remove();
                if (rm.left != null)
                    q.add(rm.left);
                if (rm.right != null)
                    q.add(rm.right);
            }
        }
        return maxWidth;
    }
}
