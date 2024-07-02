package com.dsa.dynamicprograming;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {2, -3, 5, -2, 6, -8, 2, 1, 9, -6, 4};
        System.out.println(findMaxSumOfSubArray(arr));
    }

    private static int findMaxSumOfSubArray(int[] arr) {
        int currentSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            if (maxSum < currentSum)
                maxSum = currentSum;
            if (currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }
}
