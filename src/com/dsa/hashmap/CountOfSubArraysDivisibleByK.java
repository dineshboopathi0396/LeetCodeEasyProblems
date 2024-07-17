package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubArraysDivisibleByK {
    public static void main(String[] args) {
        int[] arr = {9, 4, 20, 3, 10, 0, 11, 0};
        int k = 3;
        System.out.println(findCountSubArraysDivisibleByK(arr, k));
    }

    private static int findCountSubArraysDivisibleByK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int mod = Math.abs(sum % k);
            if (map.containsKey(mod)) {
                count++;
                map.put(mod, map.get(mod) + 1);
            } else {
                map.put(mod, 1);
            }
        }
        return count;
    }
}
