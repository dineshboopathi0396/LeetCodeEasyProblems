package com.dsa.linkedlist;

import com.leetcode.easy.ListNode;

import java.util.List;

public class IsPalindrome {
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
                                new ListNode(2,
                                        new ListNode(1, null)))));
        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode first = head;
        ListNode mid = findMiddleNode(head);
        ListNode second = reverseLinkedList(mid.next);

        while (first != null && second != null) {
            if (first.val != second.val)
                return false;
            first = first.next;
            second = second.next;
        }
        return true;
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

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null, next = null, current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
