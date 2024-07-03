package com.dsa.sorting;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {170, 79, 608, 721, 9, 99, 199, 10};
        radixSort(arr);
        printArray(arr);
    }

    private static void radixSort(int[] arr) {
        int max = findMax(arr);
        int exp = 1;
        while (max > 0) {
            max /= 10;
            countingSort(arr, exp);
            exp *= 10;
        }
    }

    private static void countingSort(int[] arr, int exp) {
        //size is 10 since range of digit varies from 0-9
        int[] prefixArray = new int[10];

        //01. Create frequency of each element in given array
        for (int i = 0; i < arr.length; i++) {
            int position = (arr[i] / exp) % 10;
            prefixArray[position] += 1;
        }

        //02. Convert this array to prefix sum array;
        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + prefixArray[i];
        }

        //03. traverse into the original array and try to fill ans[]
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int position = (arr[i] / exp) % 10;
            ans[prefixArray[position] - 1] = arr[i];
            prefixArray[position]--;
        }

        //04. Copy ans to original array
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
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
