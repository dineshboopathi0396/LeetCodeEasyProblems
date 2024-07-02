package com.dsa.sorting;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {6, 8, 1, 3, 1, 4, 9, 1, 2, 8, 8, 7};
        int[] ans = countingSort(arr);
        printArray(ans);
    }

    private static int[] countingSort(int[] arr) {
        int max = findMax(arr);
        int[] prefixArray = new int[max + 1];

        //01. Create frequency of each element in given array
        for (int i = 0; i < arr.length; i++) {
            prefixArray[arr[i]] += 1;
        }

        //02. Convert this array to prefix sum array;
        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + prefixArray[i];
        }

        //03. traverse into the original array and try to fill ans[]
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[prefixArray[arr[i]] - 1] = arr[i];
            prefixArray[arr[i]]--;
        }

        return ans;
    }

    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i]);
        return max;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
