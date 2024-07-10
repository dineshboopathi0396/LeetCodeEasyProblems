package com.leetcode.medium.string;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static void main(String[] args) {
        String word = "PAYPALISHIRING";
        int rows = 3;
        System.out.println(convert(word, rows));
    }

    private static String convert(String s, int numRows) {
        int increment = 2 * (numRows - 1);
        if (numRows == 1) return s;
        List<StringBuilder> rowsList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rowsList.add(new StringBuilder());
        }
        for (int row = 0; row < numRows; row++) {
            for (int i = row; i < s.length(); i += increment) {
                rowsList.get(row).append(s.charAt(i));
                if (row > 0 && row < numRows - 1 && (i + increment - 2 * row) < s.length()) {
                    rowsList.get(row).append(s.charAt(i + increment - 2 * row));
                }
            }
        }
        for (StringBuilder row : rowsList) {
            sb.append(row);
        }
        return sb.toString();
    }
}
