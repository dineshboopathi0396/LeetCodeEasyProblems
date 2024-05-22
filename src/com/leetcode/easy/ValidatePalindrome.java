package com.leetcode.easy;

import java.util.Stack;

public class ValidatePalindrome {
    public static void main(String[] args) {
        String s = "$A man, a plan, a canal: Panama$";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        char[] chArr = s.toCharArray();
        if (chArr.length > 1) {
            int i = 0, j = chArr.length - 1;
            while (i < j) {
                if (chArr[i] != chArr[j])
                    return false;
                i++;
                j--;
            }
        }
        return true;
    }

}
