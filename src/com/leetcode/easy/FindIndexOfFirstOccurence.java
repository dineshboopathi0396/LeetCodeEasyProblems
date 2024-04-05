package com.leetcode.easy;

public class FindIndexOfFirstOccurence {
    public static void main(String[] args) {
        String s1 = "helloworld";
        String s2 = "world";
        System.out.println(findIndexOfFirstOccurence(s1, s2));
    }

    private static int findIndexOfFirstOccurence(String s1, String s2) {
        return s1.indexOf(s2);
    }
}
