package com.leetcode.easy;

import com.dsa.binarytree.BinaryTree;
import com.dsa.binarytree.Node;

public class MinDepthBinaryTree {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        System.out.println(minDepth(bt.root));
    }

    private static int minDepth(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null)
            return 1 + minDepth(root.right);
        if (root.right == null)
            return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
