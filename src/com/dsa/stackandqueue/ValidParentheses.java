package com.dsa.stackandqueue;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String str = "{()}[]";
        System.out.println(isValidParentheses(str));
        ;
    }

    private static boolean isValidParentheses(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else {
                if (st.isEmpty())
                    return false;
                if (ch == ')' && st.peek() == '(')
                    st.pop();
                else if (ch == '}' && st.peek() == '{')
                    st.pop();
                else if (ch == ']' && st.peek() == '[')
                    st.pop();
                else
                    return false;
            }
        }
        if (st.isEmpty())
            return true;
        else
            return false;
    }
}
