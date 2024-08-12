package com.dsa.recursionandbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int position = 0;

        printPermutations(arr, position, new boolean[arr.length], new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>();
        List input = Arrays.stream(arr)    // Convert int[] to IntStream
                .boxed()             // Convert IntStream to Stream<Integer>
                .collect(Collectors.toList());
        printPermutationsBySwapping(input, position, ans);
        System.out.println(ans);
    }

    private static void printPermutationsBySwapping(List<Integer> arr, int position, List<List<Integer>> ans) {
        if (position >= arr.size()) {
            ans.add(new ArrayList<>(arr));
            return;
        }

        for (int i = position; i < arr.size(); i++) {
            swap(arr, position, i);
            printPermutationsBySwapping(arr, position + 1, ans);
            swap(arr, position, i);
        }
    }

    private static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
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
