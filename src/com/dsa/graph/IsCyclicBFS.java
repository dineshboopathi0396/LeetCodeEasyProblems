package com.dsa.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class IsCyclicBFS {

    public static void main(String[] args) {
        ArrayList<Integer>[] graph = new ArrayList[10];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].addAll(new ArrayList<>(Arrays.asList(1)));
        graph[1].addAll(new ArrayList<>(Arrays.asList(0, 2)));
        graph[2].addAll(new ArrayList<>(Arrays.asList(1)));
//        graph[3].addAll(new ArrayList<>(Arrays.asList(4, 5)));
//        graph[4].addAll(new ArrayList<>(Arrays.asList(3, 6, 7)));
//        graph[5].addAll(new ArrayList<>(Arrays.asList(3, 6, 8)));
//        graph[6].addAll(new ArrayList<>(Arrays.asList(4, 5, 7, 9)));
//        graph[7].addAll(new ArrayList<>(Arrays.asList(4, 6)));
//        graph[8].addAll(new ArrayList<>(Arrays.asList(5)));
//        graph[9].addAll(new ArrayList<>(Arrays.asList(6)));

        boolean[] visited = new boolean[graph.length];
        boolean ans = false;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (isCyclicByBFS(graph, i, visited)) {
                    ans = true;
                    break;
                }
            }
        }
        System.out.println(ans);

    }

    private static boolean isCyclicByBFS(ArrayList<Integer>[] graph, int src, boolean[] visited) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, -1));
        visited[src] = true;
        while (!q.isEmpty()) {
            Pair rp = q.remove();
            for (int nbr : graph[rp.vertex]) {
                if (nbr != rp.parent) {
                    if (visited[nbr] == true) {
                        return true;
                    }
                    visited[nbr] = true;
                    q.add(new Pair(nbr, rp.vertex));
                }
            }
        }
        return false;
    }
}
