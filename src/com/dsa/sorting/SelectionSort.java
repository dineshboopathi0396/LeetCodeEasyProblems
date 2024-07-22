package com.dsa.sorting;

import static com.dsa.sorting.CountingSort.printArray;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {12, 46, 24, 52, 20, 9};
        selectionSort(arr);
        printArray(arr);
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            swap(arr, i, min);
        }
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
