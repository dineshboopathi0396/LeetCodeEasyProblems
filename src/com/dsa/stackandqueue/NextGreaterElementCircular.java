package com.dsa.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementCircular {
    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 8, 2};
        int[] ans = generateNextGreaterElementCircular(arr);
        printArray(ans);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] generateNextGreaterElementCircular(int[] arr) {
        Stack<Integer> st = new Stack<>();

        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);
        st.push(0);
        for (int i = 1; i < 2 * arr.length; i++) {

            //1. POP all the smaller elements in the stack --> NGE is current element
            while (!st.isEmpty() && arr[st.peek()] < arr[i % arr.length]) {
                ans[st.peek()] = arr[i % arr.length];
                st.pop();
            }

            //2. Add current index to stack
            st.push(i % arr.length);
        }

        return ans;
    }
}
