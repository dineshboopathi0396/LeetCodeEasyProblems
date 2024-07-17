package com.leetcode.easy.trees;

import com.dsa.binarytree.BinaryTree;
import com.dsa.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrderTraversal {
    static List<Integer> preOrderList = new ArrayList<>();

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        System.out.println(preOrderTraversal(bt.root));
    }

    public static List<Integer> preOrderTraversal(Node root) {
        traverse(root);
        return preOrderList;
    }

    private static void traverse(Node root) {
        if (root == null){
            preOrderList.add(-1);
            return;
        }

        preOrderList.add(root.data);
        traverse(root.left);
        traverse(root.right);

    }
}
