package com.dsa.linkedlist;

import com.leetcode.easy.ListNode;

public class RemoveDuplicatesInSortedLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(3,
                        new ListNode(3,
                                new ListNode(3,
                                        new ListNode(5,
                                                new ListNode(6,
                                                        new ListNode(6, null)))))));
        head = removeDuplicates(head);
        printLinkedList(head);
    }

    private static ListNode removeDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode next = curr.next;
        while (curr != null) {
            if (next != null && curr.val == next.val) {
                next = next.next;
            } else {
                curr.next = next;
                curr = curr.next;
            }
        }
        return head;
    }

    private static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
