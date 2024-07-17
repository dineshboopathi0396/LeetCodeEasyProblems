package com.leetcode.easy;

public class ClimbingStairs {

    public static void main(String[] args) {
        int stair = 55007;
//        System.out.println(climbStairs(stair));
//        System.out.println(climbStairs1(stair));
//        System.out.println(climbStairs2(stair));
//        System.out.println(climbStairsTest(stair, new int[stair + 1]));
        System.out.println(climbStairsTabulation(stair, new int[stair + 1]));
    }

    private static int climbStairsTest(int n, int[] dp) {
        if (n <= 1)
            return 1;
        dp[1] = 1;
        dp[2] = 2;
        if (dp[n] != 0)
            return dp[n];
        int result = climbStairsTest(n - 1, dp) + climbStairsTest(n - 2, dp);
        dp[n] = result;
        return result;
    }

    private static int climbStairsTabulation(int n, int[] dp) {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[dp.length - 1]%1000000007;
    }

    private static int climbStairs2(int n) {
        if (n <= 1)
            return 1;
        int previousStep = 1;
        int nextPrev = 2;
        int steps = nextPrev;

        for (int i = 3; i <= n; i++) {
            steps = previousStep + nextPrev;
            previousStep = nextPrev;
            nextPrev = steps;

        }
        return steps;
    }

    private static int climbStairs(int n) {
        if (n <= 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairs(n - 2) + climbStairs(n - 1);
    }

    private static int climbStairs1(int n) {
        if (n <= 1)
            return 1;
        int[] steps = new int[n + 1];
        steps[1] = 1;
        steps[2] = 2;

        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i - 2] + steps[i - 1];
        }

        return steps[n];
    }
}
