package com.dsa.sorting;

import static com.dsa.sorting.CountingSort.printArray;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {12, 46, 24, 52, 20, 9};
        int[] arr = {12, 13, 24, 25, 26, 91};
        bubbleSort(arr);
        printArray(arr);
    }

    private static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            boolean isSwapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwapped = true;
                }
            }
            if (isSwapped) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
