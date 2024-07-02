package com.dsa.dynamicprograming;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String a = "abcd";
        String b = "acbd";
        System.out.println(lcs(a, b, 0, 0));
        System.out.println(lcsByMemoization(a, b, 0, 0, new int[a.length()][b.length()]));
        System.out.println(lcsByTabulation(a, b));
    }

    private static int lcsByTabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    private static int lcsByMemoization(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() || j == s2.length())
            return 0;
        if (dp[i][j] != 0)
            return dp[i][j];
        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + lcsByMemoization(s1, s2, i + 1, j + 1, dp);
        } else {
            ans = Math.max(lcsByMemoization(s1, s2, i, j + 1, dp), lcsByMemoization(s1, s2, i + 1, j, dp));
        }
        dp[i][j] = ans;
        return ans;
    }

    private static int lcs(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length())
            return 0;
        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + lcs(s1, s2, i + 1, j + 1);
        } else {
            ans = Math.max(lcs(s1, s2, i, j + 1), lcs(s1, s2, i + 1, j));
        }
        return ans;
    }
}
