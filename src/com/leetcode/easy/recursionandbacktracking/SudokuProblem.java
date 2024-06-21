package com.leetcode.easy.recursionandbacktracking;

public class SudokuProblem {
    public static void main(String[] args) {
        int n = 9;
        char[][] arr = new char[][]{
                {
                        '5', '3', '.', '.', '7', '.', '.', '.', '.'
                },
                {
                        '6', '.', '.', '1', '9', '5', '.', '.', '.'
                },
                {
                        '.', '9', '8', '.', '.', '.', '.', '6', '.'
                },
                {
                        '8', '.', '.', '.', '6', '.', '.', '.', '3'
                },
                {
                        '4', '.', '.', '8', '.', '3', '.', '.', '1'
                },
                {
                        '7', '.', '.', '.', '2', '.', '.', '.', '6'
                },
                {
                        '.', '6', '.', '.', '.', '.', '2', '8', '.'
                },
                {
                        '.', '.', '.', '4', '1', '9', '.', '.', '5'
                },
                {
                        '.', '.', '.', '.', '8', '.', '.', '7', '9'
                }
        };

        solveSudoku(arr);
    }

    private static void solveSudoku(char[][] arr) {
        if (sudokuSolver(arr, 0, 0)) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                    if ((j + 1) % 3 == 0) {
                        System.out.print("|");
                    }
                }
                System.out.println("");
                if ((i + 1) % 3 == 0) {
                    System.out.println("_ _ _ _ _ _ _ _ _ _ _");
                }
            }
        }
    }

    private static boolean sudokuSolver(char[][] arr, int x, int y) {
        if (x == arr.length) {
            return true;
        }

        int nx = y == 8 ? x + 1 : x;
        int ny = y == 8 ? 0 : y + 1;

        if (arr[x][y] == '.') {
            for (int val = 1; val <= 9; val++) {
                if (canWePlaceVal(arr, x, y, val)) {
                    arr[x][y] = (char) (val + '0');
                    if (sudokuSolver(arr, nx, ny))
                        return true;
                    arr[x][y] = '.';
                }
            }
        } else {
            if (sudokuSolver(arr, nx, ny))
                return true;
        }
        return false;
    }

    private static boolean canWePlaceVal(char[][] arr, int x, int y, int val) {
        //check for row -> row is constant
        for (int col = 0; col < arr[0].length; col++) {
            if (arr[x][col] == (char) (val + '0'))
                return false;
        }

        //check for column
        for (int row = 0; row < arr.length; row++) {
            if (arr[row][y] == (char) (val + '0'))
                return false;
        }

        //check for grid 3*3
        x = x - (x % 3);
        y = y - (y % 3);
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (arr[x + i][y + j] == (char) (val + '0'))
                    return false;
            }
        }
        return true;
    }
}
