package com.leetcode.easy.Arrays;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3, 5, 5, 5, 5, 5, 5, 5, 7, 8, 8, 10};
        int target = 5;
        findFirstAndLastIndex(arr, target);
    }

    private static void findFirstAndLastIndex(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int first = -1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        //Find Last Index
        left = 0;
        right = arr.length - 1;
        int last = -1;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(first + " " + last);
    }
}
