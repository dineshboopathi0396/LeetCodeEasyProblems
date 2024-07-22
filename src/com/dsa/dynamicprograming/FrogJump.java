package com.dsa.dynamicprograming;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        //Steps = 6
        int[] arr = {30};
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println("Minimum steps: " + calcMinCost(arr, arr.length - 1));
        System.out.println("Minimum steps: " + calcMinCostByMemoization(arr, arr.length - 1, dp));
        int[] dp1 = new int[arr.length];
        Arrays.fill(dp1, -1);
        System.out.println("Minimum steps: " + calcMinCostByTabulation(arr, dp1));
    }

    private static int calcMinCost(int[] arr, int n) {
        if (n == 0)
            return 0;
        int lCost = calcMinCost(arr, n - 1) + (Math.abs(arr[n] - arr[n - 1]));
        int rCost = 0;
        if (n > 1) {
            rCost = calcMinCost(arr, n - 2) + (Math.abs(arr[n] - arr[n - 2]));
        }
        int minCost = Math.min(lCost, rCost);
        System.out.println("Test");
        return minCost;
    }

    private static int calcMinCostByMemoization(int[] arr, int n, int[] dp) {
        if (n == 0)
            return 0;
        if (dp[n] != -1) {
            return dp[n];
        }
        int lCost = calcMinCostByMemoization(arr, n - 1, dp) + (Math.abs(arr[n] - arr[n - 1]));
        int rCost = 0;
        if (n > 1) {
            rCost = calcMinCostByMemoization(arr, n - 2, dp) + (Math.abs(arr[n] - arr[n - 2]));
        }
        int minCost = Math.min(lCost, rCost);
        System.out.println("Test");
        dp[n] = minCost;
        return minCost;
    }

    private static int calcMinCostByTabulation(int[] arr, int[] dp) {
        dp[0] = 0;
        dp[1] = Math.min(Math.abs(arr[0] - arr[1]), arr[1]);
        int minCost = 0;
        for (int i = 2; i < dp.length; i++) {
            int lCost = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int rCost = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            dp[i] = Math.min(lCost, rCost);
        }
        return dp[dp.length - 1];
    }
}
