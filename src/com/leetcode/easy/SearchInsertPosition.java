package com.leetcode.easy;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int target = 3;
        int[] arr = {1, 4};
        System.out.println(searchInsert(arr, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = 0;
        if (nums[end] < target)
            return end + 1;
        if (nums[start] > target)
            return start;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
                if (nums[end] < target)
                    return mid;
            } else {
                start = mid + 1;
                if (nums[start] > target)
                    return start;
            }
        }

        return mid;
    }
}
