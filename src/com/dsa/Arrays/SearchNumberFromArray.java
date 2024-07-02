package com.dsa.Arrays;

public class SearchNumberFromArray {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int target = 3;
        System.out.println(searchNumberFromArray(nums, target));
    }

    private static int searchNumberFromArray(int[] nums, int target) {
        int left = 0, rignht = nums.length - 1, mind = 0;
        while (left <= rignht) {
            mind = (left + rignht) / 2;
            if (nums[mind] == target) {
                return mind;
            }
            if (nums[left] <= nums[mind]) {
                if (nums[left] <= target && target < nums[mind]) {
                    rignht = mind - 1;
                } else {
                    left = mind + 1;
                }
            } else {
                if (nums[mind] < target && target <= nums[rignht]) {
                    left = mind + 1;
                } else {
                    rignht = mind - 1;
                }
            }
        }
        return -1;
    }
}
