package com.dsa.algorithm;

public class LongestPlindromicSubstring {
    public static int expand_around_center(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static String longest_palindrome(String s) {
        // if length of string is less than 1 return empty string
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand_around_center(s, i, i);
            int len2 = expand_around_center(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        // return longest palindromic substring
        return s.substring(start, end + 1);
    }

    public static void main(String[] args){
        String word = "findnitianhere";
        System.out.println(longest_palindrome(word));
    }
}
