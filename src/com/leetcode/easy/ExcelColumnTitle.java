package com.leetcode.easy;

public class ExcelColumnTitle {
    public static void main(String[] args) {
        int columnNumber = 18278;
        double d1 = 70.389;
        System.out.println(d1 / 2);
        System.out.println(Double.parseDouble("50000"));
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
            if (reminder == 0) {
                stringBuilder.append(Character.toString((64 + 26)));
                columnNumber--;
            }
        }
        stringBuilder.append(Character.toString((64 + columnNumber)));
        return stringBuilder.reverse().toString();
    }
}
