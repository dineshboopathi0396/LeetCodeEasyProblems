package com.dsa.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitioning {

    //Given a String s, Partition s such that every substring of s should be a palindrome. Return all possible palindrome
    public static void main(String[] args) {

        String s = "aabb";
        List<List<String>> result = new ArrayList<>();
        List<String> partionList = new ArrayList<>();
        getPalindromicPartitioning(0, s, partionList, result);
        System.out.println(result);

    }

    private static void getPalindromicPartitioning(int idx, String s, List<String> partionList, List<List<String>> result) {
        if (idx == s.length()) {
            result.add(new ArrayList<>(partionList));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                partionList.add(s.substring(idx, i + 1));
                getPalindromicPartitioning(i + 1, s, partionList, result);
                partionList.remove(partionList.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
