package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MaximumConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {11, 7, 1, 17, 6, 2, 3, 16, 8, 4, 9, 10, 15};
        System.out.println(findMaxLengthOfConsecutiveSequence(arr));
    }

    private static int findMaxLengthOfConsecutiveSequence(int[] arr) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] - 1)) {
                map.put(arr[i], false);
            }
        }
        int maxLen = 1;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i])) {
                int currLen = 1;
                int val = arr[i];
                while (map.containsKey(val + 1)) {
                    currLen++;
                    val++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }
}
