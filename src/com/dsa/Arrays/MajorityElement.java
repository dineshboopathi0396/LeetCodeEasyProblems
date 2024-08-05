package com.dsa.Arrays;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        System.out.println(findMajorityElement(nums));
    }

    private static int findMajorityElement(int[] nums) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numberMap.containsKey(nums[i])) {
                numberMap.put(nums[i], numberMap.get(nums[i]) + 1);
            } else {
                numberMap.put(nums[i], 1);
            }
        }

        return numberMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }


}
