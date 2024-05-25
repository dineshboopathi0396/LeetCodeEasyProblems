package com.leetcode.easy;

public class ExcelColumnTitle {
    public static void main(String[] args) {
        int columnNumber = 27;
        System.out.println(convertToColumnTitle(columnNumber));
    }

    private static String convertToColumnTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        int reminder = 0;
        while (columnNumber > 26) {
            reminder = columnNumber % 26;
            columnNumber = columnNumber / 26;
            if (reminder > 0)
                stringBuilder.append(Character.toString((64 + reminder)));
        }
        stringBuilder.append(Character.toString((64 + columnNumber)));
        return stringBuilder.reverse().toString();
    }
}
