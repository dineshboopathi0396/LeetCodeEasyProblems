package com.dsa.binarytree;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int d) {
        this.data = d;
        this.left = this.right = null;
    }
}