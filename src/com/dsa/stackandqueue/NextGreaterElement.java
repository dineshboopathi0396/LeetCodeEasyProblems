package com.dsa.stackandqueue;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {7, 6, 3, 8, 2, 11, 30, 5, 25};
        int[] ans = generateNextGreaterElement(arr);
        printArray(ans);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] generateNextGreaterElement(int[] arr) {
        Stack<Integer> st = new Stack<>();

        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            //Remove all smaller elements
            while (!st.isEmpty() && st.peek() < arr[i]) {
                st.pop();
            }
            //update ans
            if (st.size() == 0) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            //add current element
            st.push(arr[i]);
        }
        return ans;
    }
}
