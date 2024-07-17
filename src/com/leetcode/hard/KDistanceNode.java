package com.leetcode.hard;

import com.dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.Scanner;

public class KDistanceNode {
    public static void main(String[] args) {
        //Sample ==> 1 2 4 8 150 -1 -1 -1 9 -1 -1 5 10 30 70 -1 -1 80 -1 -1 10 90 -1 -1 -1 20 50 100 -1 -1 110 -1 -1 60 -1 -1 3 6 -1 -1 7 -1 -1
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode().construct(sc);
        int k = 3;
        int target = 5;
        System.out.println(new KDistanceNode().solve(root, target, k));
    }
//    static ArrayList<Integer> result = new ArrayList();
    public ArrayList<Integer> solve(TreeNode A, int B, int C) {
        ArrayList<Integer> result = new ArrayList();
        findTargetForKDistance(A, B, C, result);
        return result;
    }
    private static int findTargetForKDistance(TreeNode root, int target, int k, ArrayList<Integer> result) {
        if(root == null)
            return -1;
        if(root.val == target){
            kLevelDown(root, k, null, result);
            return 1;
        }

        int lAns = findTargetForKDistance(root.left, target, k, result);
        if(lAns > 0){
            kLevelDown(root, k - lAns, root.left, result);
            return lAns + 1;
        }
        int rAns = findTargetForKDistance(root.right, target, k, result);
        if (rAns > 0) {
            kLevelDown(root, k - rAns, root.right, result);
            return rAns + 1;
        }
        return -1;
    }

    private static void kLevelDown(TreeNode root, int level, TreeNode blockerNode, ArrayList<Integer> result){
        if(root == null || root == blockerNode)
            return;
        if(level == 0){
            result.add(root.val);
        }

        kLevelDown(root.left, level - 1, blockerNode, result);
        kLevelDown(root.right, level - 1, blockerNode, result);
    }
}
