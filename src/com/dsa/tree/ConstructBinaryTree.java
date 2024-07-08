package com.dsa.tree;

public class ConstructBinaryTree {
    public static void main(String[] args) {
        int[] pre = {1, 7, 2, 6, 5, 11, 9, 10, 4};
        int[] in = {2, 7, 5, 6, 11, 1, 9, 4, 10};

        TreeNode root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        new LevelOrderTraversal().levelOrderTraversal(root);
    }

    private static TreeNode construct(int[] pre, int si1, int ei1, int[] in, int si2, int ei2) {
        if (si1 > ei1)
            return null;
        if (si1 == ei1)
            return new TreeNode(pre[si1]);

        TreeNode root = new TreeNode(pre[si1]);
        int idx = -1;
        for (int i = si2; i < ei2; i++) {
            if (pre[si1] == in[i]) {
                idx = i;
                break;
            }
        }

        root.left = construct(pre, si1 + 1, si1 + (idx - si2), in, si2, idx - 1);
        root.right = construct(pre, si1 + (idx - si2) + 1, ei1, in, idx + 1, ei2);
        return root;
    }
}
