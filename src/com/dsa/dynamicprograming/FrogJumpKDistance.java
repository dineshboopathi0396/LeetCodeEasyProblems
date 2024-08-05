package com.dsa.dynamicprograming;

import java.util.Arrays;

public class FrogJumpKDistance {

    public static void main(String[] args) {
        //Steps = 6
        int k = 5;
        int[] arr = {30, 10, 60, 10, 60, 50};
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println("Minimum steps: " + calcMinCost(arr, k, arr.length - 1));
        System.out.println("Minimum steps: " + calcMinCostByMemoization(arr, arr.length - 1, k, dp));
        int[] dp1 = new int[arr.length];
        Arrays.fill(dp1, -1);
        System.out.println("Minimum steps: " + calcMinCostByTabulation(arr, k, dp1));
    }

    private static int calcMinCostByTabulation(int[] arr, int k, int[] dp) {
        dp[0] = 0;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                int cost = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                minCost = Math.min(cost, minCost);
            }
            dp[i] = minCost;
        }
        return dp[n - 1];
    }

    private static int calcMinCostByMemoization(int[] arr, int n, int k, int[] dp) {
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int minCost = Integer.MAX_VALUE;

        for (int j = 1; j <= k && n - j >= 0; j++) {
            int cost = calcMinCost(arr, k, n - j) + Math.abs(arr[n] - arr[n - j]);
            minCost = Math.min(cost, minCost);
        }
        dp[n] = minCost;
        return minCost;
    }

    private static int calcMinCost(int[] arr, int k, int n) {
        if (n == 0)
            return 0;
        int minCost = Integer.MAX_VALUE;

        for (int j = 1; j <= k && n - j >= 0; j++) {
            int cost = calcMinCost(arr, k, n - j) + Math.abs(arr[n] - arr[n - j]);
            minCost = Math.min(cost, minCost);
        }
        return minCost;
    }
}
