package com.leetcode.easy.Arrays;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, -1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 6};
        int target = 6;
        System.out.println(threeSum(nums, target));
    }

    public static List threeSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int newTarget = target - nums[i];
                int j = i + 1, k = n - 1;
                while (j < k) {
                    if (nums[j] + nums[k] == newTarget) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] < newTarget) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
