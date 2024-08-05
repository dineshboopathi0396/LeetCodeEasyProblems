package com.dsa.recursionandbacktracking;

public class Palindrome {
    public static void main(String[] args) {
        String s = "madam1";
        System.out.println(isPalindrome(s, 0, s.length() - 1));
    }

    private static boolean isPalindrome(String s, int i, int j) {
        if (i >= j)
            return true;
        if (s.charAt(i) != s.charAt(j))
            return false;
        return isPalindrome(s, i + 1, j - 1);
    }
}
