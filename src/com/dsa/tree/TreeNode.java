package com.dsa.tree;

import com.dsa.binarytree.Node;

import java.util.Scanner;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode construct(Scanner sc) {
        int data = sc.nextInt();
        //base case
        if (data == -1) {
            return null;
        }
        //recursive
        TreeNode node = new TreeNode(data);
        node.left = construct(sc);
        node.right = construct(sc);

        return node;
    }
}

