package com.dsa.recursionandbacktracking;

import java.util.ArrayList;

public class PrintSubSequenceWithSumK {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        int k = 3;
        System.out.println("printSubSequenceWithSumK");
        printSubSequenceWithSumK(arr, 0, new ArrayList<Integer>(), 0, k);
        System.out.println("printSubSequenceWithSumK1");
        printSubSequenceWithSumK1(arr, 0, new ArrayList<Integer>(), k);
        System.out.println("printFirstSubSequenceWithSumK");
        printFirstSubSequenceWithSumK(arr, 0, new ArrayList<Integer>(), k);
        System.out.println("countSubSequenceWithSumK");
        int count = countSubSequenceWithSumK(arr, 0, new ArrayList<Integer>(), k);
        System.out.println(count);
    }

    private static int countSubSequenceWithSumK(int[] arr, int idx, ArrayList<Integer> result, int k) {
        if (idx >= arr.length) {
            if (k == 0) {
                return 1;
            }

            return 0;
        }

        result.add(arr[idx]);
        int left = countSubSequenceWithSumK(arr, idx + 1, result, k - arr[idx]);
        result.remove(result.size() - 1);
        int right = countSubSequenceWithSumK(arr, idx + 1, result, k);
        return left + right;
    }

    private static boolean printFirstSubSequenceWithSumK(int[] arr, int idx, ArrayList<Integer> result, int k) {
        if (idx >= arr.length) {
            if (k == 0) {
                System.out.println(result);
                return true;
            }

            return false;
        }

        result.add(arr[idx]);
        if (printFirstSubSequenceWithSumK(arr, idx + 1, result, k - arr[idx]))
            return true;
        result.remove(result.size() - 1);
        if (printFirstSubSequenceWithSumK(arr, idx + 1, result, k))
            return true;
        return false;
    }

    private static void printSubSequenceWithSumK(int[] arr, int idx, ArrayList<Integer> result, int sum, int k) {
        if (idx >= arr.length) {
            if (sum == k)
                System.out.println(result);
            return;
        }

        result.add(arr[idx]);
        printSubSequenceWithSumK(arr, idx + 1, result, sum + arr[idx], k);
        result.remove(result.size() - 1);
        printSubSequenceWithSumK(arr, idx + 1, result, sum, k);
    }

    private static void printSubSequenceWithSumK1(int[] arr, int idx, ArrayList<Integer> result, int k) {
        if (idx >= arr.length) {
            if (k == 0)
                System.out.println(result);
            return;
        }

        result.add(arr[idx]);
        printSubSequenceWithSumK1(arr, idx + 1, result, k - arr[idx]);
        result.remove(result.size() - 1);
        printSubSequenceWithSumK1(arr, idx + 1, result, k);
    }
}
