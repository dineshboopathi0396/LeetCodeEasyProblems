package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphDFS {
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
                dfs(graph, i, visited);
        }

    }

    private static void dfs(ArrayList<Integer>[] graph, int src, boolean[] visited) {
        System.out.print(src + " -> ");
        visited[src] = true;
        for (int nbr : graph[src]) {
            if (!visited[nbr])
                dfs(graph, nbr, visited);
        }
    }
}
