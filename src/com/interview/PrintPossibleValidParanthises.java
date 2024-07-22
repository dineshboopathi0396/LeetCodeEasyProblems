package com.interview;

import java.util.Stack;

public class PrintPossibleValidParanthises {
    static int count = 0;
    public static void main(String[] args) {
        int n = 20;
        System.out.println(printPossibleValidParanthesis("{", n - 1, n, ""));
    }

    private static int printPossibleValidParanthesis(String str, int open, int close, String ans) {
        if (open < 0)
            return 0;
        ans += str;
        if (open == 0 && close == 0 && isValid(ans)) {
            count++;
//            System.out.println(ans);
            return 1;
        }

//        if (open > 0)
        if (open < close) {
            printPossibleValidParanthesis("{", open - 1, close, ans);
        }
//        if (close > 0)
        if (open < close) {
            printPossibleValidParanthesis("}", open, close - 1, ans);
        }
        return count;
    }

    private static boolean isValid(String ans) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == '{')
                stack.push(ans.charAt(i));
            else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
