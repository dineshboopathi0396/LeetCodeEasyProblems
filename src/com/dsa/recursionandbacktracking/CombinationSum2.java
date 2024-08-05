package com.dsa.recursionandbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 2, 2, 1, 3};
        int target = 0;

        System.out.println(combinationSum2(arr, target, 0));
    }

    private static List<List<Integer>> combinationSum2(int[] arr, int target, int idx) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        findCombinationSum(arr, target, idx, ans, new ArrayList<Integer>());
        return ans;
    }

    private static void findCombinationSum(int[] arr, int target, int idx, List<List<Integer>> ans, ArrayList<Integer> currList) {
        if (target == 0) {
            ans.add(new ArrayList<>(currList));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1])
                continue;

            if (target < arr[i]) {
                break;
            }
            currList.add(arr[i]);
            findCombinationSum(arr, target - arr[i], idx + 1, ans, currList);
            currList.remove(currList.size() - 1);
        }
    }
}
