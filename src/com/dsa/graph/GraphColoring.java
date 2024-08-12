package com.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphColoring {
    public static void main(String[] args) {
        int N = 4, M = 3;
        List<Integer>[] G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<>();
        }
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);
        int[] color = new int[N];
        boolean ans = graphColoring(G, color, 0, M);
        if (ans == true)
            System.out.println("1");
        else
            System.out.println("0");
    }

    private static boolean graphColoring(List<Integer>[] g, int[] color, int vertex, int m) {

        int n = g.length;
        if (solve(g, color, vertex, n, m)) {
            return true;
        }
        return false;
    }

    private static boolean solve(List<Integer>[] g, int[] color, int vertex, int n, int m) {
        if (vertex == g.length)
            return true;
        for (int i = 1; i <= m; i++) {
            if (isSafe(vertex, g, color, n, i)) {
                color[vertex] = i;
                if (solve(g, color, vertex + 1, n, m))
                    return true;
                color[vertex] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int vertex, List<Integer>[] g, int[] color, int n, int clr) {
        for (int nbr : g[vertex]) {
            if (color[nbr] == clr)
                return false;
        }
        return true;
    }
}
