package com.dsa.Arrays;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr = {11, 23, 45};
        int m = arr.length;
        int[] arr1 = {1, 24, 25, 67, 68};
        int n = arr1.length;
        arr = Arrays.copyOf(arr, m+n);
        merge(arr, m, arr1, n);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1, j = n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
