package com.leetcode.easy;

public class Palindrome {
    public static void main(String[] args) {
        int num = 121;
        System.out.println(isPalindrome(num));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int reverse = 0;
        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }
        if (reverse == x) {
            return true;
        } else {
            return false;
        }
    }
}
