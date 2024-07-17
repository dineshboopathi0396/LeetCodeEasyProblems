package com.leetcode.easy;

public class IsSubSequence {
    public static void main(String[] args) {
        String s = "adhk";
        String t = "asdasdgdfdhhjk";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())
            return false;
        int sLen = s.length();
        int tLen = t.length();
        int i = 0, j = 0;
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i == sLen)
            return true;
        else
            return false;
    }
}
