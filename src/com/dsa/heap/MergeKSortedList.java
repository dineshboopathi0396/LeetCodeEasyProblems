package com.dsa.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(10, 22, 28, 35, 111),
                Arrays.asList(6, 16, 41, 41, 43),
                Arrays.asList(29, 41, 82, 89, 100),
                Arrays.asList(21, 44, 47, 67, 78)
        ));
        System.out.println(mergeKSortedLists(arr));
    }

    private static ArrayList<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            pq.add(new Pair(lists.get(i).get(0), i, 0));
        }

        while (pq.size() != 0) {
            Pair rp = pq.remove();
            ans.add(rp.val);
            if (rp.di + 1 < lists.get(rp.li).size()) {
                pq.add(new Pair(lists.get(rp.li).get(rp.di + 1), rp.li, rp.di + 1));
            }
        }
        return ans;
    }
}
