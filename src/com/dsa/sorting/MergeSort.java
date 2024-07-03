package com.dsa.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 99, 11, 45, 23, 45, 65, 68, 90};
        int start = 0, end = arr.length - 1;
        int[] ans = new MergeSort().mergeSort(arr, start, end);
        printArray(ans);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private int[] mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            int[] baseAns = new int[1];
            baseAns[0] = arr[start];
            return baseAns;
        }
        int mid = (start + end) / 2;
        int[] firstHalf = mergeSort(arr, start, mid);
        int[] secondHalf = mergeSort(arr, mid + 1, end);
        return mergeSortedArray(firstHalf, secondHalf);

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
}
