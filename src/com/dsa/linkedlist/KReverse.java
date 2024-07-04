package com.dsa.linkedlist;

import com.leetcode.easy.ListNode;

public class KReverse {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6, null))))));

//        ListNode head = new ListNode(1,
//                new ListNode(2,
//                        new ListNode(3,
//                                new ListNode(2,
//                                        new ListNode(1, null)))));
        int k = 3;
        ListNode reversedHead = reverseKNodes(head, k);
        printLinkedList(reversedHead);
    }

    private static ListNode reverseKNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pointer = dummy;

        while (pointer != null) {
            //Check if K Nodes Present
            ListNode node = pointer;
            for (int i = 1; i <= k && node != null; i++) {
                node = node.next;
            }
            if (node == null) {
                break;
            }

            //Reverse K nodes
            ListNode prev = null, current = pointer.next;
            for (int i = 1; i <= k; i++) {
                ListNode next = current.next;
                current.next = prev;

                prev = current;
                current = next;
            }

            //Update other values
            ListNode tail = pointer.next;
            pointer.next = prev;

            tail.next = current;
            pointer = tail;
        }
        return dummy.next;
    }

    private static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
