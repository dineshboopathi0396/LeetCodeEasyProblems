package com.leetcode.easy.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;


public class IsCyclicByBFSInDirectedGraph {
    public static void main(String[] args) {
        int A = 5;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
//        B.add(new ArrayList<>(Arrays.asList(1, 2)));
//        B.add(new ArrayList<>(Arrays.asList(4, 1)));
//        B.add(new ArrayList<>(Arrays.asList(2, 4)));
//        B.add(new ArrayList<>(Arrays.asList(3, 4)));
//        B.add(new ArrayList<>(Arrays.asList(5, 2)));
//        B.add(new ArrayList<>(Arrays.asList(1, 3)));

        B.add(new ArrayList<>(Arrays.asList(1, 2)));
        B.add(new ArrayList<>(Arrays.asList(2, 3)));
        B.add(new ArrayList<>(Arrays.asList(3, 4)));
        B.add(new ArrayList<>(Arrays.asList(4, 5)));

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> al : B) {
            adj.get(al.get(0)).add(al.get(1));
        }
        boolean[] vis = new boolean[A + 1];
        int ans = 0;
        for (int i = 1; i <= A; i++) {
            if (vis[i] == false) {
                if (isCyclicByBFS(adj, i, vis)) ans = 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean isCyclicByBFS(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, -1));
        visited[src] = true;
        while (q.size() > 0) {
            Pair rp = q.remove();
            for (int nbr : graph.get(rp.vertex)) {
                if (nbr != rp.parent) {
                    if (visited[nbr] == true) {
                        return true;
                    }
                    q.add(new Pair(nbr, rp.vertex));
                    visited[nbr] = true;
                }
            }
        }
        return false;
    }
}
