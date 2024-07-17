package com.leetcode.hard;

import java.util.ArrayList;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        char[][] arr = new char[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = '.';
            }
        }

        ArrayList<ArrayList<String>> queenList = new ArrayList();
        placeNQueens(queenList, arr, n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);

//        queenList = convert(arr);
        System.out.println(queenList);
    }


    private static ArrayList<String> construct(char[][] board) {
        ArrayList<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }

    private static void placeNQueens(ArrayList<ArrayList<String>> result, char[][] arr, int n, int row, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            result.add(construct(arr));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!cols[col] && !d1[row + col] && !d2[row - col + n - 1]) {
                arr[row][col] = 'Q';
                cols[col] = true;
                d1[row + col] = true;
                d2[row - col + n - 1] = true;
                placeNQueens(result, arr, n, row + 1, cols, d1, d2);
                arr[row][col] = '.';
                cols[col] = false;
                d1[row + col] = false;
                d2[row - col + n - 1] = false;
            }
        }
    }
}
