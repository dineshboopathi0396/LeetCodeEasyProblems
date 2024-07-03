package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {
        int n = 5;
        char[][] chars = buildTriangle(n, new char[n][n]);
        printTriangle(chars);
        printTriangleAsteric(n);

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.stream().filter(i -> i % 2 == 0).map(num -> num * num).collect(Collectors.toList()));

        List<String> strList = new ArrayList<>();
        strList.add("abc123");
        strList.add("abcd");
        strList.add("abcde");

        Collections.sort(strList, (s1, s2) -> {
            if (s1.toString().length() > s2.toString().length())
                return 1;
            else
                return -1;
        });
        System.out.println(strList);

    }

    private static void printTriangleAsteric(int n) {
        int maxCount = 2 * n - 1;
        int mid = (maxCount + 1) / 2;
        int i = 1;
        while (i <= n) {
            for (int j = 1; j <= maxCount; j++) {
                if (j >= (mid - (i - 1)) && j <= (mid + i - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println("");
            i++;
        }
    }

    private static void printTriangle(char[][] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println("");
        }
    }

    private static char[][] buildTriangle(int n, char[][] chars) {
        int start = n, end = -1;
        for (int i = n - 1; i >= 0; i--) {
            int j = start - 1, k = end + 1;
            while (k <= j) {
                chars[i][k] = '*';
                chars[i][j] = '*';
                j--;
                k++;
            }
            start--;
            end++;
        }
        return chars;
    }
}
