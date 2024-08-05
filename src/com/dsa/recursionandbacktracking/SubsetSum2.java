package com.dsa.recursionandbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum2 {
    //    Print all the unique subset sum
    public static void main(String[] args) {
        int[] arr = {1, 1, 2};

        System.out.println(printAllUniqueSubsetSum(arr, 0));
    }

    private static List<List<Integer>> printAllUniqueSubsetSum(int[] arr, int idx) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        findUniqueSubsets(arr, idx, new ArrayList<>(), ans);
        return ans;
    }

    private static void findUniqueSubsets(int[] arr, int idx, List<Integer> currList, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(currList));
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1])
                continue;
            currList.add(arr[i]);
            findUniqueSubsets(arr, i + 1, currList, ans);
            currList.remove(currList.size() - 1);
        }
    }
}
