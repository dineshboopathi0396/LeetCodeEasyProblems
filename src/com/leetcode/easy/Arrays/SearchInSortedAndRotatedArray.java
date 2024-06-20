package com.leetcode.easy.Arrays;

public class SearchInSortedAndRotatedArray {
    public static void main(String[] args) {
        int[] arr = {9, 11, 14, 15, 20, 22, 25, 2, 3, 5, 7};
        int target = 2;
        int minIdx = findMin(arr);
        System.out.println("minIdx: " + minIdx);
        int ans = binarySearch(arr, 0, minIdx - 1, target);
        if (ans == -1) {
            ans = binarySearch(arr, minIdx, arr.length - 1, target);
        }
        System.out.println("ans : " + ans);
    }

    private static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
