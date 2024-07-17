package com.leetcode.easy;

public class MaxHourGlassSum {

    public static void main(String[] args) {
        int[][] arr = {
                {6, 2, 1, 3},
                {4, 2, 1, 5},
                {9, 2, 8, 7},
                {4, 1, 2, 9}
        };
        System.out.println(maxHGSum(arr));
    }

    private static int maxHGSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[0].length - 2; j++) {
                int sum = 0;
                for (int col = j; col < j + 3; col++) {
                    sum += arr[i][col];
                }
                sum += arr[i + 1][j + 1];
                for (int col = j; col < j + 3; col++) {
                    sum += arr[i + 2][col];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
