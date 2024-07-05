package com.dsa.Arrays;

//Update the matrix in such a way that if a cell contains 0 updated the entire row and col as zero;
public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 1}
        };
        System.out.println("Before Modification:");
        print2DArray(arr);
        setZeros(arr);
        System.out.println("After Modification:");
        print2DArray(arr);
    }

    private static void print2DArray(int[][] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[0].length - 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static void setZeros(int[][] arr) {
        //Step1: iterate and set the row and col value to zero
        int col0 = 1;
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[0].length - 1; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    if (j != 0) {
                        arr[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        //Iterate through the un-modified data
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    if (arr[i][0] == 0 || arr[0][j] == 0) {
                        arr[i][j] = 0;
                    }
                }
            }
        }

        //Fill 0th row and 0th Col
        if (arr[0][0] == 0) {
            for (int j = 0; j < arr[0].length; j++) arr[0][j] = 0;
        }
        if (col0 == 0) {
            for (int i = 0; i < arr.length; i++) arr[i][0] = 0;
        }
    }
}
