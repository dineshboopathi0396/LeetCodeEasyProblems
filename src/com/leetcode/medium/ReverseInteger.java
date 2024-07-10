package com.leetcode.medium;

public class ReverseInteger {
    public static void main(String[] args) {
        int n = -123;
        System.out.println(reverse(n));
    }

    private static int reverse(int n) {
        int result = 0;
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = -n;
        }
        while (n != 0) {
            if (result > (Integer.MAX_VALUE - (n % 10)) / 10) {
                return 0;
            }
            result = (result * 10) + (n % 10);
            n = n / 10;
        }
        return isNegative ? -result : result;
    }
}
