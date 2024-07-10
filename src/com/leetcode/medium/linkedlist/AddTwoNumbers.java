package com.leetcode.medium.linkedlist;

import com.leetcode.easy.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9, null)))))));

        ListNode head2 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9, null))));
        ListNode head = addTwoNumbersOfLinkedList(head1, head2);
        printLinkedList(head);
    }

    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private static ListNode addTwoNumbersOfLinkedList(ListNode l1, ListNode l2) {
        int a = 0, b = 0, sum = 0, carry = 0;
        ListNode result = new ListNode();
        ListNode dummy = result;
        while (l1 != null || l2 != null || carry != 0) {
            a = l1 != null ? l1.val : 0;
            b = l2 != null ? l2.val : 0;

            sum = carry + a + b;
            carry = sum / 10;
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

        }
        return result.next;
    }
}
