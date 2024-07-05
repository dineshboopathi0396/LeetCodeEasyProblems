package com.dsa.Arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {7, 6, 3, 8, 2, 11, 30, 5, 25};
        System.out.println(findLeaders(arr));
    }

    private static List<Integer> findLeaders(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if (arr.length == 0)
            return list;
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (max < arr[i]) {
                max = arr[i];
                list.add(max);
            }
        }
        return list;
    }


    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
