package com.dsa.graph;

import com.dsa.tree.TreeNode;

import java.util.*;

public class GraphBFS {
    public static void main(String[] args) {
        ArrayList<Integer>[] graph = new ArrayList[7];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].addAll(new ArrayList<>(Arrays.asList(1, 2, 3)));
        graph[1].addAll(new ArrayList<>(Arrays.asList(0, 2)));
        graph[2].addAll(new ArrayList<>(Arrays.asList(0, 1, 3)));
        graph[3].addAll(new ArrayList<>(Arrays.asList(0, 4)));
        graph[4].addAll(new ArrayList<>(Arrays.asList(2, 3)));
        graph[5].addAll(new ArrayList<>(Arrays.asList(6)));
        graph[6].addAll(new ArrayList<>(Arrays.asList(5)));

        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i])
                bfs(graph, i, visited);
        }

    }

    private static void bfs(ArrayList<Integer>[] graph, int src, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        visited[src] = true;

        while (!q.isEmpty()){
            int rm = q.remove();
            System.out.print(rm + " -> ");
            for (int nbr : graph[rm]){
                if (!visited[nbr]){
                    visited[nbr] = true;
                    q.add(nbr);
                }
            }
        }
    }
}
