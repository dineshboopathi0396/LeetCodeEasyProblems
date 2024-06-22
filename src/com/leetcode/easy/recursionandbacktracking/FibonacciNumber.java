package com.leetcode.easy.recursionandbacktracking;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 10;
        int ans = findFibonacciNumber(n);
        System.out.println(ans);
        System.out.println(fibTabulation(n, new int[n + 1]));
    }

    private static int fibTabulation(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    private static int findFibonacciNumber(int n) {
        if (n == 0 || n == 1)
            return n;
        int fn = findFibonacciNumber(n - 1) + findFibonacciNumber(n - 2);
        return fn;
    }
}
