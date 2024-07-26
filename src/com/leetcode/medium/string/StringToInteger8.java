package com.leetcode.medium.string;

public class StringToInteger8 {

    public static void main(String[] args) {
        String s = "  ";
        System.out.println(myAtoi(s));
        System.out.println(myAtoiOptimized(s));

    }

    private static int myAtoi(String s) {
        boolean negative = false;
        boolean valid = false;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ans > Integer.MAX_VALUE) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (s.charAt(i) == '-' || s.charAt(i) == '+' || s.charAt(i) == ' ' || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                if (s.charAt(i) == '-') {
                    if (!valid) {
                        negative = true;
                    } else {
                        break;
                    }
                } else if (s.charAt(i) != ' ' && s.charAt(i) != '+') {
                    valid = true;
                    ans = (ans * 10) + (s.charAt(i) - '0');
                }
            } else {
                break;
            }
        }
        if (negative) {
            ans = -ans;
        }
        if (ans < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return ans;
        }
    }

    private static int myAtoiOptimized(String s) {
        if (s.length() == 0)
            return 0;
        int i = 0, ans = 0;


        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        int negative = 1;
        if (i >= s.length())
            return 0;
        if (s.charAt(i) == '-') {
            negative = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        if (i < s.length() && s.charAt(i) < '0' && s.charAt(i) > '9') {
            return 0;
        }
        while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
            int digit = s.charAt(i) - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return negative == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = (ans * 10) + digit;
            i++;
        }
        return negative * ans;
    }
}
