package com.interview.zoho;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silen1";
        System.out.println(isAnagram(s1, s2));
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            if ((s1.charAt(i) >= 'a' && s1.charAt(i) <= 'z') && (s2.charAt(i) >= 'a' && s2.charAt(i) <= 'z')) {
                count[s1.charAt(i) - 'a']++;
                count[s2.charAt(i) - 'a']--;
            } else {
                return false;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }
}
