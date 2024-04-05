package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
        int[] result1 = twoSum1(nums, target);
        System.out.println(result1[0] + " " + result1[1]);
        int[] result2 = twoSum2(nums, target);
        System.out.println(result2[0] + " " + result2[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(target - nums[i])) {
                return new int[]{result.get(target - nums[i]), i};
            }
            result.put(nums[i], i);
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                if (nums[j] + nums[j - i] == target) {

                    return new int[]{j, j - i};
                }
            }
        }
        return null;
    }
}
