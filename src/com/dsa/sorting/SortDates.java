package com.dsa.sorting;

public class SortDates {
    public static void main(String[] args) {
        String[] arr = {"05121968", "04121968", "17121996", "11081972", "05061997", "11081990", "12081990"};
        sortDates(arr);
        printArray(arr);
    }

    private static void sortDates(String[] arr) {
        countingSort(arr, 31, 1000000, 100);//for Day range [1-31]
        countingSort(arr, 12, 10000, 100);//for Month range [1-12]
        countingSort(arr, 2500, 1, 10000);//for year range [1-2500]
    }

    private static void countingSort(String[] arr, int range, int div, int mod) {
        //size is 10 since range of digit varies from 0-9
        int[] prefixArray = new int[range + 1];

        //01. Create frequency of each element in given array
        for (int i = 0; i < arr.length; i++) {
            int position = (Integer.parseInt(arr[i]) / div) % mod;
            prefixArray[position] += 1;
        }

        //02. Convert this array to prefix sum array;
        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + prefixArray[i];
        }

        //03. traverse into the original array and try to fill ans[]
        String[] ans = new String[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int position = (Integer.parseInt(arr[i]) / div) % mod;
            ans[prefixArray[position]- 1] = arr[i];
            prefixArray[position]--;
        }

        //04. Copy ans to original array
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
    }

    private static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
