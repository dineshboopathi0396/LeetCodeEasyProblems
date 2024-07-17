package com.leetcode.medium.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixSearch {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7, 8, 9, 10),
                Arrays.asList(11, 12, 13, 14, 15),
                Arrays.asList(16, 17, 18, 19, 20),
                Arrays.asList(21, 22, 23, 24, 25)
        ));
        int target = 19;
        System.out.println(searchMatrix(arr, target));
    }

    public static int searchMatrix(List<List<Integer>> A, int B) {
        int i = 0, j = A.get(0).size() - 1;
        while (i < A.size() && j >= 0) {
            if (A.get(i).get(j) == B) {
                return 1;
            } else if (A.get(i).get(j) < B) {
                i++;
            } else {
                j--;
            }
        }
        return 0;
    }
}
