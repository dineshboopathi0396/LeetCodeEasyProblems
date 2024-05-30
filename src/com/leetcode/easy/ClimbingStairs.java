package com.leetcode.easy;

public class ClimbingStairs {

    public static void main(String[] args) {
        int stair = 2;
        System.out.println(climbStairs(stair));
        System.out.println(climbStairs1(stair));
        System.out.println(climbStairs2(stair));
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
