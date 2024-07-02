package com.dsa.Arrays;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 6, 8, 10},
                {2, 7, 9, 12, 15},
                {3, 11, 20, 22, 24},
                {5, 16, 25, 30, 40}
        };
        int target = 11;
        System.out.println(binarySearchInMatrix(arr, target));
    }

    private static boolean binarySearchInMatrix(int[][] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i < arr.length && j >= 0) {
            if (arr[i][j] == target) {
                return true;
            } else if (arr[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
