package com.dsa.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] ans = rotateArrayApproach2(arr, k);
        printArray(ans);
        System.out.println();
        rotateArrayApproach1(arr, k);
        printArray(arr);
    }

    private static int[] rotateArrayApproach2(int[] arr, int k) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int idx = (i + k) % arr.length;
            ans[idx] = arr[i];
        }
        return ans;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private static void rotateArrayApproach1(int[] arr, int k) {
        k = k % arr.length;
        //Step1: Reverse the Array
        reverseArray(arr, 0, arr.length - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, arr.length - 1);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
