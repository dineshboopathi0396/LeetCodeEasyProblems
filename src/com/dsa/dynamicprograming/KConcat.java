package com.dsa.dynamicprograming;

public class KConcat {
    public static void main(String[] args) {
        int[] arr = {1, -4, -3, 2};
        int k = 3;
        System.out.println(maxSum(arr, k));
    }

    private static int maxSum(int[] arr, int k) {
        if (k == 1)
            return kadanesAlgo(arr, k);
        else {
            int sum = 0;
            for (int i = 0; i < arr.length; i++)
                sum += arr[i];
            if (sum > 0) {
                return sum * (k - 2) + kadanesAlgo(arr, 2);
            } else {
                return kadanesAlgo(arr, 2);
            }
        }
    }

    private static int kadanesAlgo(int[] arr, int k) {
        int currentSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length * k; i++) {
            currentSum = currentSum + arr[i % arr.length];
            if (maxSum < currentSum)
                maxSum = currentSum;
            if (currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }
}
