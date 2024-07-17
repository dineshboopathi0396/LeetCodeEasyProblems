package com.dsa.stackandqueue;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] arr = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(solveRPN(arr));
    }

    private static int solveRPN(String[] arr) {
        Stack<Integer> stInt = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("*") || arr[i].equals("/")) {
                int pop1 = stInt.pop();
                int pop2 = stInt.pop();
                stInt.push(solve(pop2, pop1, arr[i]));
            } else {
                stInt.push(Integer.parseInt(arr[i]));
            }
        }
        return stInt.pop();
    }

    private static Integer solve(int pop2, int pop1, String s) {
        if (s.equals("+"))
            return pop2 + pop1;
        else if (s.equals("-"))
            return pop2 - pop1;
        else if (s.equals("*"))
            return pop2 * pop1;
        else
            return pop2 / pop1;
    }
}
