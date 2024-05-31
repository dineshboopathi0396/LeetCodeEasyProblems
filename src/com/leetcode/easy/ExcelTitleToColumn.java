package com.leetcode.easy;

public class ExcelTitleToColumn {
    public static void main(String[] args) {
        String str = "ZZZ";
        System.out.println(titleToNumber(str));
    }

    public static int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int columnNumber = 0;
        for (int i = 0; i < chars.length; i++) {
            columnNumber = columnNumber * 26 + ((chars[i] - 'A') + 1);
        }
        return columnNumber;
    }
}
