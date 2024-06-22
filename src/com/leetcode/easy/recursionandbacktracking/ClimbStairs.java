package com.leetcode.easy.recursionandbacktracking;


public class ClimbStairs {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbUsingRecursion(n));
        System.out.println(climbUsingDPMemoization(n, new int[n + 1]));
        System.out.println(climbUsingDPTabulation(n, new int[n + 1]));
    }

    private static int climbUsingDPTabulation(int n, int[] dp) {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[dp.length-1];
    }

    private static int climbUsingDPMemoization(int n, int[] dp) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (dp[n] != 0)
            return dp[n];
        int ans = climbUsingDPMemoization(n - 1, dp) + climbUsingDPMemoization(n - 2, dp) + climbUsingDPMemoization(n - 3, dp);
        dp[n] = ans;
        return ans;
    }

    private static int climbUsingRecursion(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        int ans = climbUsingRecursion(n - 1) + climbUsingRecursion(n - 2) + climbUsingRecursion(n - 3);
        return ans;
    }

}
