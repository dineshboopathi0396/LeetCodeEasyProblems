package com.dsa.tree;

import com.dsa.binarytree.Node;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode().construct(sc);
        levelOrderTraversal(root);
    }

    private static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (q.size() > 0) {
            int currentWidth = q.size();
            for (int i = 1; i <= currentWidth; i++) {
                TreeNode rm = q.remove();
                System.out.print(rm.val + " ");
                if (rm.left != null)
                    q.add(rm.left);
                if (rm.right != null)
                    q.add(rm.right);
            }
            System.out.println();
        }
    }


}
