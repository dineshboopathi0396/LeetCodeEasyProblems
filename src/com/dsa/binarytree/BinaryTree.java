package com.dsa.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;



public class BinaryTree {
    public Node root;

    public BinaryTree() {
        Scanner sc = new Scanner(System.in);
        root = createTree(sc);
    }


    Node createTree(Scanner sc) {
        int data = sc.nextInt();
        //base case
        if (data == -1) {
            return null;
        }
        //recursive
        Node node = new Node(data);
        node.left = createTree(sc);
        node.right = createTree(sc);

        return node;
    }

    public void display() {
        System.out.println("PreorderPrint");
        preorderPrint(root);
        System.out.println("InorderPrint");
        inorderPrint(root);
        System.out.println("PostorderPrint");
        postorderPrint(root);
        System.out.println("levelOrderPrint");
        levelOrderPrint(root);
    }

    void preorderPrint(Node root) {
        if (root == null)
            return;
        System.out.println(root.data);
        preorderPrint(root.left);
        preorderPrint(root.right);
    }

    void inorderPrint(Node root) {
        if (root == null)
            return;
        inorderPrint(root.left);
        System.out.println(root.data);
        inorderPrint(root.right);
    }

    void postorderPrint(Node root) {
        if (root == null)
            return;
        postorderPrint(root.left);
        postorderPrint(root.right);
        System.out.println(root.data);
    }

    void levelOrderPrint(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.println(n.data);
            if (n.left != null)
                queue.offer(n.left);
            if (n.right != null)
                queue.offer(n.right);
        }
    }
}

