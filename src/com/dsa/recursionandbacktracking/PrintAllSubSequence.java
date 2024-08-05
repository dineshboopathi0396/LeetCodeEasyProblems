package com.dsa.recursionandbacktracking;

import java.util.ArrayList;

public class PrintAllSubSequence {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        printSubSequence(arr, 0, new ArrayList<Integer>());
    }

    private static void printSubSequence(int[] arr, int idx, ArrayList<Integer> result) {
        if (idx >= arr.length) {
            System.out.println(result);
            return;
        }
        result.add(arr[idx]);
        printSubSequence(arr, idx + 1, result);
        result.remove(result.size() - 1);
        printSubSequence(arr, idx + 1, result);
    }

}
