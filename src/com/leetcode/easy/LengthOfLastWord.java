package com.leetcode.easy;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String str = "Happy World";
        System.out.println(lengthOfLastWord(str));
    }

    public static int lengthOfLastWord(String s) {
        String[] strArr = s.split(" ");
        return strArr[strArr.length - 1].length();
    }
}
