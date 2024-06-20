package com.leetcode.easy.Arrays;

public class SpiralMatrixOrderII {
    public static void main(String[] args) {
        int a = 1;
        int[][] arr = createSpiralMatrix(a);
        printSpiralMatrix(arr);
    }

    private static void printSpiralMatrix(int[][] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[0].length - 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static int[][] createSpiralMatrix(int a) {
        int count = 1;
        int rMin = 0, rMax = a - 1;
        int cMin = 0, cMax = a - 1;
        int[][] arr = new int[a][a];
        while (count <= a * a) {
            for (int i = cMin; i <= cMax && count <= a * a; i++) {
                arr[rMin][i] = count;
                count++;
            }
            rMin++;
            for (int j = rMin; j <= rMax && count <= a * a; j++) {
                arr[j][cMax] = count;
                count++;
            }
            cMax--;
            for (int m = cMax; m >= cMin && count <= a * a; m--) {
                arr[rMax][m] = count;
                count++;
            }
            rMax--;
            for (int n = rMax; n >= rMin && count <= a * a; n--) {
                arr[n][cMin] = count;
                count++;
            }
            cMin++;
        }
        return arr;
    }

}
