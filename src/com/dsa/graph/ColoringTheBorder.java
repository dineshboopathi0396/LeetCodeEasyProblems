package com.dsa.graph;

public class ColoringTheBorder {

    public static void main(String[] args) {
        int[][] arr = {
                {2, 3, 4, 3, 1},
                {4, 2, 2, 2, 1},
                {1, 2, 2, 2, 1},
                {5, 2, 2, 2, 1},
                {6, 7, 8, 1, 0}
        };
        int row = 1, col = 1, color = 3;
        int[][] ans = colorBorder(arr, row, col, color);
        print(ans);
    }

    private static int[][] colorBorder(int[][] arr, int row, int col, int color) {
        int oc = arr[row][col];
        dfs(arr, row, col, oc);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] < 0) {
                    arr[i][j] = color;
                }
            }
        }
        return arr;
    }

    private static void dfs(int[][] arr, int r, int c, int oc) {
        if (r < 0 || c < 0 || r >= arr.length || c >= arr[0].length || arr[r][c] != oc) {
            return;
        }
        arr[r][c] = -oc;
        //top
        dfs(arr, r - 1, c, oc);
        //down
        dfs(arr, r + 1, c, oc);
        //right
        dfs(arr, r, c + 1, oc);
        //left
        dfs(arr, r, c - 1, oc);

        if (r - 1 >= 0 && c - 1 >= 0 && r + 1 < arr.length && c + 1 < arr[0].length
                && Math.abs(arr[r - 1][c]) == oc
                && Math.abs(arr[r + 1][c]) == oc
                && Math.abs(arr[r][c - 1]) == oc
                && Math.abs(arr[r][c + 1]) == oc) {
            //The r,c is not a boundary
            arr[r][c] = oc;
        }
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
