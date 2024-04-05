package com.leetcode.easy;

import com.dsa.binarytree.BinarySearchTree;
import com.dsa.binarytree.Node;

public class IsBalancedBST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println(isBalanced(bst.root));
    }

    private static boolean isBalanced(Node root) {
        if (root == null)
            return true;
        if (findHeight(root) == -1)
            return false;
        return true;
    }

    private static int findHeight(Node root) {
        if (root == null)
            return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        if (left == -1 || right == -1)
            return -1;
        if (Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}
