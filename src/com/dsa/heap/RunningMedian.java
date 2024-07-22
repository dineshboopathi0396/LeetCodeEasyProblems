package com.dsa.heap;

import java.util.*;

public class RunningMedian {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 5, 4, 3));
        System.out.println(findRunningMedian(A));
    }

    static PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> pq2 = new PriorityQueue<>();

    private static List<Integer> findRunningMedian(List<Integer> A) {
        List<Integer> latestDeliveryList = new ArrayList<>();
        List<Integer> medians = new ArrayList<>();

        for (Integer val : A) {
            addDeliveryTime(val);
            medians.add(findMedian(pq1, pq2));
        }
        return medians;
    }

    private static Integer findMedian(PriorityQueue<Integer> pq1, PriorityQueue<Integer> pq2) {
        if (pq1.size() >= pq2.size()) {
            return pq1.peek();
        } else {
            return pq2.peek();
        }
    }

    private static void addDeliveryTime(Integer val) {
        if (pq1.isEmpty() && pq2.isEmpty()) {
            pq1.add(val);
        } else {
            if (val > pq1.peek()) {
                pq2.add(val);
            } else {
                pq1.add(val);
            }
        }
        int diff = Math.abs(pq1.size() - pq2.size());
        if (diff > 1) {
            if (pq1.size() > pq2.size()) {
                pq2.add(pq1.remove());
            } else {
                pq1.add(pq2.remove());
            }
        }
    }
}
