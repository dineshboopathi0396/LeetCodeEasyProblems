package com.dsa.tree;

import java.util.Scanner;

public class CamerasInATree {
    static int camera = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode().construct(sc);
        int noOfCameras = findMinCameras(root);
        if (noOfCameras == -1)
            camera++;
        System.out.println(camera);
    }

    private static int findMinCameras(TreeNode root) {
        if (root == null)
            return 0;

        int lAns = findMinCameras(root.left);
        int rAns = findMinCameras(root.right);

        if (lAns == -1 || rAns == -1) {
            camera++;
            return 1;
        }
        if (lAns == 1 || rAns == 1) {
            return 0;
        }
        return -1;
    }
}
