package com.leetcode.hard.string;

public class RegularExpressionMatching10 {
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s, p));

    }

    private static boolean isMatch(String s, String p) {
        int i = 0, j = 0;

        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    if (p.charAt(j) != '.') {
                        char val = p.charAt(j);
                        j += 2;
                        while (i < s.length() && s.charAt(i) == val) {
                            i++;
                        }
                    } else {
                        if (j + 2 < p.length())
                            return true;
                    }
                } else {
                    i++;
                    j++;
                }
            } else {
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    j += 2;
                } else {
                    return false;
                }
            }
        }

        if (i >= s.length()) {
            return true;
        } else {
            return false;
        }
    }
}
