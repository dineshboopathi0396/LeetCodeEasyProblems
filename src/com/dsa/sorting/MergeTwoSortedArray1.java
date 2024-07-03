package com.dsa.sorting;

public class MergeTwoSortedArray1 {
    public static void main(String[] args) {
        int[] arr = {11, 23, 45};
        int m = arr.length;
        int[] arr1 = {1, 24, 25, 67, 68};
        int n = arr1.length;
        int[] ans = mergeSortedArray(arr, arr1);
        printArray(ans);
    }

    private static int[] mergeSortedArray(int[] arr, int[] arr1) {
        int i = 0, j = 0;
        int k = 0;
        int[] ans = new int[arr.length + arr1.length];
        while (i < arr.length && j < arr1.length) {
            if (arr[i] <= arr1[j]) {
                ans[k] = arr[i];
                i++;
                k++;
            } else {
                ans[k] = arr1[j];
                j++;
                k++;
            }
        }
        while (i < arr.length) {
            ans[k] = arr[i];
            i++;
            k++;
        }
        while (j < arr1.length) {
            ans[k] = arr1[j];
            j++;
            k++;
        }
        return ans;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
