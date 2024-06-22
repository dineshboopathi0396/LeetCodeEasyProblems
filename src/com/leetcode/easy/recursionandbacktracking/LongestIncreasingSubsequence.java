package com.leetcode.easy.recursionandbacktracking;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10, 2, 9, 5, 7, 3, 60, 80, 1};
        System.out.println(lisByRecursion(arr, 0, -1));
        System.out.println(lisByMemoization(arr, 0, -1, new int[arr.length][arr.length]));

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = lisByMemoization2(arr, i);
            ans = Math.max(ans, len);
        }
        System.out.println(ans);
    }

    private static int lisByMemoization2(int[] arr, int i) {
        int max = 0;

        for (int j = 0; j < i; j++) {
            if (arr[j] < arr[i]) {
                max = Math.max(max, lisByMemoization2(arr, j));
            }
        }
        return max + 1;
    }

    private static int lisByMemoization(int[] arr, int idx, int prevIdx, int[][] dp) {
        if (idx == arr.length)
            return 0;

        if (prevIdx != -1 && dp[idx][prevIdx] != 0)
            return dp[idx][prevIdx];

        //every element has 2 option either tobe included in the subsequence or not included
        int f1 = lisByMemoization(arr, idx + 1, prevIdx, dp); //is same as [0 + lisByRecursion(arr, idx + 1, prevIdx)]
        int f2 = 0;
        if (prevIdx == -1 || arr[idx] > arr[prevIdx]) {
            f2 = 1 + lisByMemoization(arr, idx + 1, idx, dp);
        }
        int ans = Math.max(f1, f2);
        if (prevIdx != -1)
            dp[idx][prevIdx] = ans;
        return ans;
    }

    private static int lisByRecursion(int[] arr, int idx, int prevIdx) {
        if (idx == arr.length)
            return 0;

        //every element has 2 option either tobe included in the subsequence or not included
        int f1 = lisByRecursion(arr, idx + 1, prevIdx); //is same as [0 + lisByRecursion(arr, idx + 1, prevIdx)]
        int f2 = 0;
        if (prevIdx == -1 || arr[idx] > arr[prevIdx]) {
            f2 = 1 + lisByRecursion(arr, idx + 1, idx);
        }
        int ans = Math.max(f1, f2);
        return ans;
    }
}
