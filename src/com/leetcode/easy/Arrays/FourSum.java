package com.leetcode.easy.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(findSunsetsOfFourSum(arr, target));
    }

    private static List<List<Integer>> findSunsetsOfFourSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (j == 0 || arr[j] != arr[j - 1]) {
                        int newTarget = target - arr[i] - arr[j];
                        int m = j + 1, n = arr.length - 1;
                        while (m < n) {
                            if (arr[m] + arr[n] == newTarget) {
                                list.add(Arrays.asList(new Integer[]{arr[i], arr[j], arr[m], arr[n]}));
                                m++;
                                n--;
                            } else if (arr[m] + arr[n] < newTarget) {
                                m++;
                            } else {
                                n--;
                            }
                        }
                    }
                }
            }

        }
        return list;
    }
}
