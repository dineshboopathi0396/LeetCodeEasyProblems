package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumDivisibleByK {
    public static void main(String[] args) {
        int[] arr = {9, 4, 20, 3, 10, 0, 11, 0};
        int k = 33;
        System.out.println(findLongestSumDivisibleByK(arr, k));
    }

    private static int findLongestSumDivisibleByK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int mod = ((sum % k) + k) % k;// To make it positive
            if (map.containsKey(mod)) {
                maxLen = Math.max(maxLen, i - map.get(mod));
            } else {
                map.put(mod, i);
            }
        }
        return maxLen;
    }
}
