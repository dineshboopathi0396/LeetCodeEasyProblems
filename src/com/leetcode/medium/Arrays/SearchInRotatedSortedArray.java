package com.leetcode.medium.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(9, 11, 14, 15, 20, 22, 25, 2, 3, 5, 7));
        int target = 19;
        int minIdx = findMin(arr);
        int ans = binarySearch(arr, 0, minIdx - 1, target);
        if (ans == -1) {
            ans = binarySearch(arr, minIdx, arr.size() - 1, target);
        }
        System.out.println(ans);
    }

    private static int binarySearch(List<Integer> arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) == target) {
                return mid;
            } else if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int findMin(List<Integer> arr) {
        int left = 0, right = arr.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(right) > arr.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
