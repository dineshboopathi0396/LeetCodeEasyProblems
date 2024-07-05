package com.dsa.tree;

import java.util.Scanner;
import java.util.Stack;

public class LevelOrderZigZag {
    public static void main(String[] args) {
        //sample 2 7 2 -1 -1 6 5 -1 -1 11 -1 -1 5 -1 9 4 -1 -1 -1
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode().construct(sc);
        zigZagLevelOrderTraversal(root);
    }

    private static void zigZagLevelOrderTraversal(TreeNode root) {
        Stack<TreeNode> curr = new Stack<>();
        Stack<TreeNode> next = new Stack<>();

        curr.push(root);
        int level = 0;

        while (curr.size() != 0) {
            while (curr.size() != 0) {
                TreeNode rm = curr.pop();
                System.out.print(rm.val + " ");
                if (level % 2 == 0) {
                    if (rm.left != null)
                        next.push(rm.left);
                    if (rm.right != null)
                        next.push(rm.right);
                } else {
                    if (rm.right != null)
                        next.push(rm.right);
                    if (rm.left != null)
                        next.push(rm.left);
                }
            }
            System.out.println();
            level++;
            curr = next;
            next = new Stack<>();
        }
    }
}
