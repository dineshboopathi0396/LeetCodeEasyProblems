package com.leetcode.easy.trees;

import com.dsa.binarytree.BinaryTree;
import com.dsa.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        System.out.println(inorderTraversal(bt.root));
    }

    public static List<Integer> inorderTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        inOrder(root, result);
        return result;
    }

    private static void inOrder(Node root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        inOrder(root.left, result);
        result.add(root.data);
        inOrder(root.right, result);
    }
}
