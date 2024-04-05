package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
        System.out.println(romanToInt1(s));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = Map.ofEntries(
                Map.entry('I', 1),
                Map.entry('V', 5),
                Map.entry('X', 10),
                Map.entry('L', 50),
                Map.entry('C', 100),
                Map.entry('D', 500),
                Map.entry('M', 1000)
        );
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && romanMap.get(s.charAt(i)) > romanMap.get(s.charAt(i - 1))) {
                result = result - romanMap.get(s.charAt(i - 1)) + romanMap.get(s.charAt(i)) - romanMap.get(s.charAt(i - 1));
            } else {
                result += romanMap.get(s.charAt(i));
            }
        }
        return result;
    }

    public static int romanToInt1(String s) {
        Map<Character, Integer> romanMap = Map.ofEntries(
                Map.entry('I', 1),
                Map.entry('V', 5),
                Map.entry('X', 10),
                Map.entry('L', 50),
                Map.entry('C', 100),
                Map.entry('D', 500),
                Map.entry('M', 1000)
        );
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                result -= romanMap.get(s.charAt(i));
            } else {
                result += romanMap.get(s.charAt(i));
            }
        }
        return result;
    }
}
