package com.leetcode.easy.trees;

import com.dsa.binarytree.BinaryTree;
import com.dsa.binarytree.Node;


public class SymetricTree {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        System.out.println(isSymetric(bt.root));
    }

    private static boolean isSymetric(Node root) {
        if (root == null)
            return true;
        return isMirrorTree(root.left, root.right);
    }

    private static boolean isMirrorTree(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.data != node2.data)
            return false;
        return isMirrorTree(node1.left, node2.right) && isMirrorTree(node1.right, node2.left);
    }
}
