package com.interview.zoho;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {
    public static void main(String[] args){
        int[] arr = {7, 6, 3, 8, 2, 11, 30, 5, 25};
        System.out.println(findNextGreaterElementBruteForce(arr));
    }

    private static Map<Integer, Integer> findNextGreaterElementBruteForce(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            int max = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++){
                if (arr[i] < arr[j]){
                    if(arr[j] < max){
                        max = arr[j];
                    }
                }
            }
            if(max != Integer.MAX_VALUE)
                map.put(arr[i], max);
            else
                map.put(arr[i], null);
        }
        return map;
    }
}
