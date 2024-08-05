package com.dsa.recursionandbacktracking;

import java.util.ArrayList;

public class SubSetSum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4};

        printAllSubsetSum(arr, 0, 0);
    }

    private static void printAllSubsetSum(int[] arr, int idx, int sum) {
        if (idx >= arr.length) {
            System.out.println(sum);
            return;
        }

        printAllSubsetSum(arr, idx + 1, sum + arr[idx]);
        printAllSubsetSum(arr, idx + 1, sum);
    }
}
