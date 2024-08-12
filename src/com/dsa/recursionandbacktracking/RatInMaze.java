package com.dsa.recursionandbacktracking;

import java.util.ArrayList;

public class RatInMaze {

    public static void main(String[] args) {
        int n = 9;
        int[][] arr = new int[][]{
                {
                        1, 0, 0, 0
                },
                {
                        1, 1, 0, 1
                },
                {
                        1, 1, 0, 0
                },
                {
                        0, 1, 1, 1
                }
        };
        ArrayList<String> ans = new ArrayList<>();
        if (arr[0][0] == 1)
            solveMaze(arr, 0, 0, ans, "", new int[arr.length][arr[0].length]);
        System.out.println(ans);
    }

    private static void solveMaze(int[][] arr, int i, int j, ArrayList<String> ans, String move, int[][] visited) {
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            ans.add(move);
            return;
        }
        //Move Down
        if (i + 1 < arr.length && arr[i + 1][j] == 1 && visited[i + 1][j] != 1) {
            visited[i + 1][j] = 1;
            solveMaze(arr, i + 1, j, ans, move + 'D', visited);
            visited[i + 1][j] = 0;
        }

        //Move left
        if (j - 1 >= 0 && arr[i][j - 1] == 1 && visited[i][j - 1] != 1) {
            visited[i][j - 1] = 1;
            solveMaze(arr, i, j - 1, ans, move + 'L', visited);
            visited[i][j - 1] = 0;
        }

        //Move Right
        if (j + 1 < arr[0].length && arr[i][j + 1] == 1 && visited[i][j + 1] != 1) {
            visited[i][j + 1] = 1;
            solveMaze(arr, i, j + 1, ans, move + 'R', visited);
            visited[i][j + 1] = 0;
        }

        //Move Up
        if (i - 1 >= 0 && arr[i - 1][j] == 1 && visited[i - 1][j] != 1) {
            visited[i - 1][j] = 1;
            solveMaze(arr, i - 1, j, ans, move + 'U', visited);
            visited[i - 1][j] = 0;
        }
    }
}
