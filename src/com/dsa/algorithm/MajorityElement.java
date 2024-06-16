package com.dsa.algorithm;

public class MajorityElement {

    //Moore's Voting Algorithm
    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 3, 4, 7, 3, 4, 4, 7, 4, 4, 7, 4, 4};
        System.out.println(findMajorityElement(nums));
    }

    private static int findMajorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (candidate == nums[i])
                count++;
        }
        return count > nums.length / 2 ? candidate : -1;
    }
}
