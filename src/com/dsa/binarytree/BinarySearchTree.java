package com.dsa.binarytree;

import java.util.Scanner;

//8, 3, 10, 1, 6, 14, 4, 13, 7, -1
public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        this.root = buildTree();
    }

    public BinarySearchTree(int[] bstArray) {
        this.root = sortedArrayToHeightBalancedBST(bstArray);
    }

    private Node sortedArrayToHeightBalancedBST(int[] nums) {
        Node root = null;
        int start = 0, end = nums.length - 1;
        root = createHeightBalancedBST(nums, start, end);
        return root;
    }

    private Node createHeightBalancedBST(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node root = new Node(nums[mid]);
        root.left = createHeightBalancedBST(nums, start, mid - 1);
        root.right = createHeightBalancedBST(nums, mid + 1, end);
        return root;

    }

    private Node sortedArrayToBST(int[] nums) {
        Node root = null;
        int i = 0;
        while (i < nums.length) {
            root = insertNode(root, nums[i]);
            i++;
        }
        return root;
    }


    private Node buildTree() {
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        Node root = null;
        while (d != -1) {
            root = insertNode(root, d);
            d = scanner.nextInt();
        }
        return root;
    }

    private Node insertNode(Node root, int data) {
        if (root == null)
            return new Node(data);
        if (data <= root.data) {
            root.left = insertNode(root.left, data);
        } else {
            root.right = insertNode(root.right, data);
        }
        return root;
    }

    public void display() {
        System.out.println("InorderPrint");
        inorderPrint(root);
    }

    private void inorderPrint(Node root) {
        if (root == null)
            return;
        inorderPrint(root.left);
        System.out.println(root.data);
        inorderPrint(root.right);
    }

    public boolean search(int key) {
        return searchFn(this.root, key);
    }

    public boolean searchFn(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;
        if (key < root.data) {
            return searchFn(root.left, key);
        }
        return searchFn(root.right, key);

    }
}
