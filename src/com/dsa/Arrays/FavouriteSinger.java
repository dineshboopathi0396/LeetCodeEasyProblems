package com.dsa.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FavouriteSinger {
    public static void main(String args[]) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());                // Reading input from STDIN
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }   // Writing output to STDOUT

        System.out.println(favouriteSinger(arr));
    }

    private static int favouriteSinger(int[] arr) {
        int max = 1;
        int ans = arr[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < arr.length; i++) {
            int count = 1;
            if (map.containsKey(arr[i])) {
                count = map.get(arr[i]) + 1;
                map.put(arr[i], count);
            } else {
                map.put(arr[i], 1);
            }
            if (max < count) {
                max = count;
                ans = arr[i];
            } else if (max == count) {
                ans = arr[i] < ans ? ans : arr[i];
            }
        }
        return ans;
    }
}
