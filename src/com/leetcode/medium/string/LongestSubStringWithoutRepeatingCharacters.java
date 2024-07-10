package com.leetcode.medium.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(findUniqueLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring(s));

    }

    private static int findUniqueLongestSubstring(String s) {
        int start = 0;
        Map<Character, Integer> p = new HashMap();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (p.containsKey(ch) && p.get(ch) >= start) {
                start = p.get(ch) + 1;
            } else {
                max = Math.max(max, i - start + 1);
            }
            p.put(ch, i);
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }
}
