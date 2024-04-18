package com.leetcode.easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"Flow", "Flower", "Flight"};
        System.out.println(longestCommonPrefix(arr));
    }

    public static String longestCommonPrefix(String[] strs) {
        String lcp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (lcp.length() > strs[i].length())
                lcp = lcp.substring(0, strs[i].length());
            for (int j = 0; j < lcp.length() && j < strs[i].length(); j++) {
                Character c1 = lcp.charAt(j);
                Character c2 = strs[i].charAt(j);
                if (!c1.equals(c2)) {
                    lcp = lcp.substring(0, j);
                    break;
                }
            }
            if (lcp.isBlank())
                return lcp;
        }
        return lcp;
    }
}
