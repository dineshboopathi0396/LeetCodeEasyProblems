package com.dsa.sorting;

import static com.dsa.sorting.CountingSort.printArray;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 46, 24, 52, 20, 9};
//        int[] arr = {12, 13, 24, 25, 26, 91};
        insertionSort(arr);
        printArray(arr);
    }


    private static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
