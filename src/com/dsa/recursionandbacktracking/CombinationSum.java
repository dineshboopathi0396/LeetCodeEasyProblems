package com.dsa.recursionandbacktracking;

import java.util.ArrayList;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4};
        int target = 7;

        findCombinationSum(arr, target, 0, new ArrayList<Integer>());
    }

    private static void findCombinationSum(int[] arr, int target, int idx, ArrayList<Integer> result) {
        if (idx == arr.length) {
            if (target == 0) {
                System.out.println(result);
            }
            return;
        }

        if (target >= arr[idx]) {
            result.add(arr[idx]);
            findCombinationSum(arr, target - arr[idx], idx, result);
            result.remove(result.size() - 1);
        }

        findCombinationSum(arr, target, idx + 1, result);
    }
}
