package com.dsa.heap;

public class Pair implements Comparable<Pair> {
    int val;
    int di;
    int li;

    public Pair(int val, int li, int di) {
        this.val = val;
        this.di = di;
        this.li = li;
    }

    @Override
    public int compareTo(Pair o) {
        return this.val - o.val;
    }
}
