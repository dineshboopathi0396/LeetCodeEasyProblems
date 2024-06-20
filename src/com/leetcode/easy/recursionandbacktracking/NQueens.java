package com.leetcode.easy.recursionandbacktracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        char[][] arr = new char[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = '.';
            }
        }
        placeNQueens(arr, 0);
        placeNQueensOptimized(arr, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
    }

    private static void placeNQueensOptimized(char[][] arr, int row, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == arr.length) {
            print(arr);
            return;
        }
        for (int col = 0; col < arr[0].length; col++) {
            if (!cols[col] && !d1[row + col] && !d2[row - col + arr.length - 1]) {
                arr[row][col] = 'Q';
                cols[col] = true;
                d1[row + col] = true;
                d2[row - col + arr.length - 1] = true;
                placeNQueensOptimized(arr, row + 1, cols, d1, d2);
                arr[row][col] = '.';
                cols[col] = false;
                d1[row + col] = false;
                d2[row - col + arr.length - 1] = false;
            }
        }
    }


    private static void placeNQueens(char[][] arr, int row) {
        if (row == arr.length) {
            print(arr);
            return;
        }
        for (int col = 0; col < arr[0].length; col++) {
            if (isSafe(arr, row, col)) {
                arr[row][col] = 'Q';
                placeNQueens(arr, row + 1);
                arr[row][col] = '.';
            }
        }
    }

    private static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("-------------------");
    }

    private static boolean isSafe(char[][] arr, int row, int col) {
        //Check Column -> Keep Column constant
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 'Q')
                return false;
        }

        //check diagonal 1 - right
        for (int i = row - 1, j = col + 1; i >= 0 && j < arr[0].length; i--, j++) {
            if (arr[i][j] == 'Q')
                return false;
        }

        //check diagonal 2 - left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q')
                return false;
        }
        return true;
    }
}
