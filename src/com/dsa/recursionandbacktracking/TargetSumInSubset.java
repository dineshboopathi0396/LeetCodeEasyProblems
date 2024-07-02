package com.dsa.recursionandbacktracking;

import java.util.ArrayList;

public class TargetSumInSubset {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40, 50};
        int target = 60;
        printTargetSubsets(arr, 0, target, new ArrayList<Integer>());
    }

    private static void printTargetSubsets(int[] arr, int i, int target, ArrayList<Integer> result) {
        if (i == arr.length) {
            if (target == 0)
                System.out.println(result);
            return;
        }

        //select ith element
        result.add(arr[i]);
        printTargetSubsets(arr, i + 1, target - arr[i], result);
        result.remove(result.size() - 1);

        //reject ith element
        printTargetSubsets(arr, i + 1, target, result);
    }
}
