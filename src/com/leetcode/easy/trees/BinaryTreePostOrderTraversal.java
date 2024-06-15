package com.leetcode.easy.trees;

import com.dsa.binarytree.BinaryTree;
import com.dsa.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {
    static List<Integer> postOrderList = new ArrayList<>();

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        System.out.println(postOrderTraversal(bt.root));
    }

    public static List<Integer> postOrderTraversal(Node root) {
        traverse(root);
        return postOrderList;
    }

    private static void traverse(Node root) {
        if (root == null)
            return;
        traverse(root.left);
        traverse(root.right);
        postOrderList.add(root.data);
    }
}
