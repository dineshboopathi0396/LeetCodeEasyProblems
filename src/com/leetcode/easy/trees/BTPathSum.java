package com.leetcode.easy.trees;

import com.dsa.binarytree.Node;

public class BTPathSum {

    public boolean hasPathSum(Node root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.data;
        return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);
    }
}
