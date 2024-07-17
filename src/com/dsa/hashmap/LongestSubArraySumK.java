package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumK {
    public static void main(String[] args) {
        int[] arr = {9, 4, 20, 3, 10, 0, 11, 0};
        int target = 33;
        System.out.println(findLongestSumK(arr, target));
    }

    private static int findLongestSumK(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int pSum = 0;
        for (int i = 0; i < arr.length; i++) {
            pSum += arr[i];
            if (map.containsKey(pSum - target)) {
                maxLen = Math.max(maxLen, i - map.getOrDefault(pSum, 0));
            }
            map.put(pSum, i);
        }
        return maxLen;
    }
}
