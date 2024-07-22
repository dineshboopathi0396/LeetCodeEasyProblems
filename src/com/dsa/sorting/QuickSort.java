package com.dsa.sorting;

import static com.dsa.sorting.CountingSort.printArray;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12, 46, 24, 52, 20, 9};
//        int[] arr = {12, 13, 24, 25, 26, 91};
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;
        int pivot = arr[endIndex];
        int left = startIndex;
        int right = endIndex;
        while (left < right) {
            while (arr[left] <= pivot && left < right) {
                left++;
            }
            while (arr[right] >= pivot && left < right) {
                right--;
            }
            swap(arr, left, right);
        }
        swap(arr, left, endIndex);
        quickSort(arr, startIndex, left - 1);
        quickSort(arr, left + 1, endIndex);
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
