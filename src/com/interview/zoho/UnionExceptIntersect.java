package com.interview.zoho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionExceptIntersect {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 5, 3, 8, 9, 1));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 7, 5, 8, 8));
        performOperations(list1, list2);
    }

    private static void performOperations(List<Integer> list1, List<Integer> list2) {
        List<Integer> union = new ArrayList<>();
        List<Integer> intersect = new ArrayList<>();
        List<Integer> except = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            if (!union.contains(list1.get(i)))
                union.add(list1.get(i));
            if (list1.get(i) % 2 == 0)
                except.add(list1.get(i));
        }
        for (int i = 0; i < list2.size(); i++) {
            if (!union.contains(list2.get(i)))
                union.add(list2.get(i));
            if (list2.get(i) % 2 != 0)
                except.add(list2.get(i));
            if (list1.contains(list2.get(i)) && !intersect.contains(list2.get(i)))
                intersect.add(list2.get(i));
        }
        System.out.println(union);
        System.out.println(except);
        System.out.println(intersect);
    }
}
