package com.dsa.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {8, 12}, {3, 7}, {2, 6}, {9, 11}, {17, 25}, {15, 21}};
        int[][] ans = mergeIntervals(arr);
        printTwoDArray(ans);
    }

    private static void printTwoDArray(int[][] ans) {
        for (int i = 0; i < ans.length; i++) {
            System.out.println("{ " + ans[i][0] + ", " + ans[i][1] + "}");
        }
    }


    private static int[][] mergeIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        Stack<int[]> st = new Stack<>();
        st.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] < st.peek()[1]) {
                st.peek()[1] = Math.max(st.peek()[1], arr[i][1]);
            } else {
                st.push(arr[i]);
            }
        }
        int[][] ans = new int[st.size()][2];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i][0] = st.peek()[0];
            ans[i][1] = st.peek()[1];
            st.pop();
        }
        return ans;
    }
}
