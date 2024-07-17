package com.dsa.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KSumSubArray {
    public static void main(String[] args) {
        int[] arr = {9, 4, 20, 3, 10, 0, 11, 0};
        int target = 33;
        System.out.println(findKSumSubArray(arr, target));
    }



    private static int findKSumSubArray(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (map.containsKey(prefixSum - target)) {
                count += map.get(prefixSum - target);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
