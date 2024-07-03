package com.dsa.stackandqueue;

import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int[] arr = {7, 6, 3, 8, 2, 11, 30, 5, 25};
        int[] ans = generateNextGreaterElementApproach2(arr);
        printArray(ans);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] generateNextGreaterElementApproach2(int[] arr) {
        Stack<Integer> st = new Stack<>();

        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            //1. POP all the smaller elements in the stack --> NGE is current element
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                ans[st.peek()] = arr[i];
                st.pop();
            }

            //2. Add current index to stack
            st.push(i);
        }
        //3. Empty the stack and assign -1
        while (!st.isEmpty()) {
            ans[st.pop()] = -1;
        }
        return ans;
    }
}
