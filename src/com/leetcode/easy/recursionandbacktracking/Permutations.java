package com.leetcode.easy.recursionandbacktracking;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int position = 0;

        printPermutations(arr, position, new boolean[arr.length], new ArrayList<>());
    }

    private static void printPermutations(int[] arr, int position, boolean[] selected, ArrayList<Object> ans) {
        if (position == arr.length) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!selected[i]) {
                ans.add(arr[i]);
                selected[i] = true;
                printPermutations(arr, position + 1, selected, ans);
                selected[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }
}
