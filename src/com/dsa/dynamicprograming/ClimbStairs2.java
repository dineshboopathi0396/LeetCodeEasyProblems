package com.dsa.dynamicprograming;

public class ClimbStairs2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 6, 5, 2, 7, 1};
        int n = arr.length;
        System.out.println(findMinCostByRecursion(arr, n));
        System.out.println(findMinCostByDPMemoization(arr, n, new int[n + 1]));
        System.out.println(findMinCostByDPTabulation(arr, n, new int[n]));
    }

    private static int findMinCostByDPTabulation(int[] arr, int n, int[] dp) {
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + arr[i];
        }
        return dp[dp.length - 1];
    }

    private static int findMinCostByDPMemoization(int[] arr, int n, int[] dp) {
        if (n == 1)
            return arr[0];
        if (n == 2)
            return arr[0] + arr[1];

        if (dp[n] != 0)
            return dp[n];
        int ans = Math.min(findMinCostByDPMemoization(arr, n - 1, dp), findMinCostByDPMemoization(arr, n - 2, dp)) + arr[n-1];
        dp[dp.length - 1] = ans;
        return ans;
    }

    private static int  findMinCostByRecursion(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        if (n == 2)
            return arr[0] + arr[1];
        int ans = Math.min(findMinCostByRecursion(arr, n - 1), findMinCostByRecursion(arr, n - 2)) + arr[n - 1];
        return ans;
    }
}
