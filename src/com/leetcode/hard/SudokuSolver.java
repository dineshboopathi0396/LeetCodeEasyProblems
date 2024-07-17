package com.leetcode.hard;

import java.util.ArrayList;

public class SudokuSolver {

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
        ArrayList<ArrayList<Character>> arrayList = new ArrayList<>();
        arrayList = convertToArrayList(arr);
        if (solveSudoku(arrayList, 0, 0)) {
            printSudoku(arrayList);
        }
        System.out.println("");
    }

    private static void printSudoku(ArrayList<ArrayList<Character>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(0).size(); j++) {
                System.out.print(arr.get(i).get(j) + " ");
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

    private static boolean solveSudoku(ArrayList<ArrayList<Character>> arrayList, int x, int y) {
        if (x == arrayList.size()) {
            return true;
        }
        int nx = y == 8 ? x + 1 : x;
        int ny = y == 8 ? 0 : y + 1;

        if (arrayList.get(x).get(y) == '.') {
            for (int val = 1; val <= 9; val++) {

                if (canWePlace(arrayList, x, y, val)) {
                    arrayList.get(x).set(y, (char) (val + '0'));
                    if (solveSudoku(arrayList, nx, ny)) {
                        return true;
                    }
                    arrayList.get(x).set(y, '.');
                }
            }
        } else {
            if (solveSudoku(arrayList, nx, ny)) {
                return true;
            }
        }
        return false;
    }

    private static boolean canWePlace(ArrayList<ArrayList<Character>> arrayList, int x, int y, int val) {
        //check for row -> row is constant
        for (int col = 0; col < arrayList.get(0).size(); col++) {
            if (arrayList.get(x).get(col) == (char) (val + '0'))
                return false;
        }

        //check for column
        for (int row = 0; row < arrayList.size(); row++) {
            if (arrayList.get(row).get(y) == (char) (val + '0'))
                return false;
        }

        //check for grid 3*3
        x = x - (x % 3);
        y = y - (y % 3);
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (arrayList.get(x + i).get(y + j) == (char) (val + '0'))
                    return false;
            }
        }
        return true;
    }

    public static ArrayList<ArrayList<Character>> convertToArrayList(char[][] charArray) {
        ArrayList<ArrayList<Character>> arrayList = new ArrayList<>();
        for (char[] row : charArray) {
            ArrayList<Character> listRow = new ArrayList<>();
            for (char c : row) {
                listRow.add(c);
            }
            arrayList.add(listRow);
        }
        return arrayList;
    }
}
