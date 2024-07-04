package com.dsa.linkedlist;

import com.leetcode.easy.ListNode;

public class MiddleNode {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1,
//                new ListNode(2,
//                        new ListNode(3,
//                                new ListNode(4,
//                                        new ListNode(5,
//                                                new ListNode(6, null))))));

        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));
        ListNode mid = findMiddleNode(head);
        System.out.println(mid.val);
    }

    private static ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
