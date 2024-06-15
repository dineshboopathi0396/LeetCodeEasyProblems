package com.leetcode.easy.trees;

import com.dsa.binarytree.BinaryTree;
import com.dsa.binarytree.Node;

public class MaxDepthOfTree {
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        System.out.println(findMaxDepth(bt.root));
    }

    private static int findMaxDepth(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(findMaxDepth(root.left), findMaxDepth(root.right));
    }
}
