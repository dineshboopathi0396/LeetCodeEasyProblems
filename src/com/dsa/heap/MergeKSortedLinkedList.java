package com.dsa.heap;

import com.leetcode.easy.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

    public static void main(String[] args) {
        ArrayList<ListNode> a = new ArrayList<>();
        ListNode l1 = new ListNode(1, new ListNode(10, new ListNode(20)));
        ListNode l2 = new ListNode(4, new ListNode(11, new ListNode(13)));
        ListNode l3 = new ListNode(3, new ListNode(8, new ListNode(9)));
        a.add(l1);
        a.add(l2);
        a.add(l3);
        ListNode result = mergeKLinkedLists(a);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public static ListNode mergeKLinkedLists(ArrayList<ListNode> a) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for (int i = 0; i < a.size(); i++) {
            pq.add(a.get(i));
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (pq.size() != 0) {
            ListNode rn = pq.remove();
            node.next = new ListNode(rn.val);
            node = node.next;
            if (rn.next != null) {
                pq.add(rn.next);
            }
        }
        return dummy.next;
    }
}
