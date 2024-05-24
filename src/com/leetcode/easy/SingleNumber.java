package com.leetcode.easy;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 4, 5, 5, 4};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
