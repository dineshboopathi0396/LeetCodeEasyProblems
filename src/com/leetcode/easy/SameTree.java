package com.leetcode.easy;

import com.dsa.binarytree.BinaryTree;
import com.dsa.binarytree.Node;

public class SameTree {
    public static void main(String[] args) {
        BinaryTree b1 = new BinaryTree();
        BinaryTree b2 = new BinaryTree();
        System.out.println(isSameTree(b1.root, b2.root));
    }

    private static boolean isSameTree(Node root, Node root1) {
        if (root == null && root1 == null)
            return true;
        if (root.data == root1.data && root != null && root1 != null)
            return isSameTree(root.left, root1.left) && isSameTree(root.right, root1.right);
        return false;
    }
}
