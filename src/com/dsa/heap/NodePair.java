package com.dsa.heap;

import com.leetcode.easy.ListNode;

public class NodePair implements Comparable<Pair>{
    int val;
    ListNode dn;
    int li;
    public NodePair(int val, int li, ListNode dn) {
        this.val = val;
        this.dn = dn;
        this.li = li;
    }

    @Override
    public int compareTo(Pair o) {
        return this.val - o.val;
    }
}
