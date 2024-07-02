package com.dsa.Arrays;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        spiralMatrix(arr);
    }

    private static void spiralMatrix(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int rMin = 0, rMax = n - 1;
        int cMin = 0, cMax = m - 1;
        int count = 0;
        while (count < m * n) {
            //Top Boundary
            for (int i = cMin; i <= cMax && count < m * n; i++) {
                System.out.print(arr[rMin][i] + " ");
                count++;
            }
            rMin++;
            //right Boundary
            for (int i = rMin; i <= rMax && count < m * n; i++) {
                System.out.print(arr[i][cMax] + " ");
                count++;
            }
            cMax--;
            //Bottom Boundary
            for (int i = cMax; i >= 0 && count < m * n; i--) {
                System.out.print(arr[rMax][i] + " ");
                count++;
            }
            rMax--;
            //Left Boundary
            for (int i = rMax; i >= 0 && count < m * n; i--) {
                System.out.print(arr[i][cMin] + " ");
                count++;
            }
            cMin++;
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
