package com.dsa.Arrays;

public class SortedAndRotatedArray {
    public static void main(String[] args) {
        int[] arr = {9, 11, 14, 15, 20, 22, 25, 2, 3, 5, 7};
        System.out.println(isArraySortedAndRotated(arr));
    }

    private static boolean isArraySortedAndRotated(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[(i + 1) % arr.length])
                count++;
            if (count > 1)
                return false;
        }
        return true;
    }
}
