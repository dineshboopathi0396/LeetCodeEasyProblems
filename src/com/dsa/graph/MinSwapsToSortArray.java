package com.dsa.graph;

public class MinSwapsToSortArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 1, 3, 6, 0};
        System.out.println(findMinSwaps(arr));
    }

    private static int findMinSwaps(int[] arr) {
        int ans = 0;
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                int j = i;
                int len = 1;
                while (arr[j] != i) {
                    j = arr[j];
                    visited[j] = true;
                    len++;
                }
                ans += (len - 1);
            }
        }
        return ans;
    }
}
