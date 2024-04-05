package com.leetcode.easy;

public class RemoveDuplicateInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates1(nums));
    }

    private static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static int removeDuplicates1(int[] nums) {
        int i=0,j=1;
        while(j<nums.length){
            if(nums[i]==nums[j]) j++;
            else nums[++i] = nums[j++];
        }
        return i+1;
    }
}
