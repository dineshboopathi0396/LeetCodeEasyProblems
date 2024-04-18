package com.leetcode.easy;

public class AddBinary {
    public static void main(String[] args) {
        String a = "110";
        String b = "111";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        int carry = 0;
        int sum = 0;
        StringBuilder s = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry == 1) {
            sum = carry;
            if (i >= 0)
                sum += a.charAt(i) - '0';
            if (j >= 0)
                sum += b.charAt(j) - '0';
            if (sum == 0 || sum == 1) {
                s.append(sum);
                carry = 0;
            } else if (sum == 2) {
                s.append('0');
                carry = 1;
            } else {
                s.append('1');
                carry = 1;
            }
            i--;
            j--;
        }
        return s.reverse().toString();
    }
}
