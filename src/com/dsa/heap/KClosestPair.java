package com.dsa.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPair {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>(Arrays.asList(
                Arrays.asList(3, 3),
                Arrays.asList(5, -1),
                Arrays.asList(-2, 4),
                Arrays.asList(1, 4),
                Arrays.asList(-2, 3),
                Arrays.asList(4, 3)
        ));
        int k = 3;
        System.out.println(findKClosestPair(arr, k));
    }

    private static List<List<Integer>> findKClosestPair(List<List<Integer>> arr, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((p1, p2) ->
                p2.get(0) * p2.get(0) + p2.get(1) * p2.get(1) - p1.get(0) * p1.get(0) - p1.get(1) * p1.get(1));
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            pq.add(arr.get(i));
            if (pq.size() > k) {
                pq.remove();
            }
        }
        for (int i = 0; i < k; i++) {
            ans.add(pq.remove());
        }
        return ans;
    }
}
