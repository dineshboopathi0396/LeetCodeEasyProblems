package com.leetcode.easy.trees;

import com.dsa.binarytree.BinarySearchTree;

import java.util.Scanner;

public class BSTFromArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lenght = sc.nextInt();
        int[] bstArray = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            bstArray[i] = sc.nextInt();
        }

        BinarySearchTree bst = new BinarySearchTree(bstArray);
        bst.display();
    }
}
