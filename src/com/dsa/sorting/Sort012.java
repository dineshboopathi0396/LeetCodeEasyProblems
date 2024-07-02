package com.dsa.sorting;

public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 1, 2, 0, 1, 0, 1, 0, 0, 2, 0, 2, 1};
        sort012(arr);
        printArray(arr);
    }

    private static void sort012(int[] arr) {
        int i = 0, j = 0, k = arr.length - 1;
        while (i <= k) {
            if (arr[i] == 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
                i++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                k--;
            }
        }
    }


    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
