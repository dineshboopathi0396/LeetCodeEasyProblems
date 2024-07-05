package com.dsa.linkedlist;

import com.leetcode.easy.ListNode;

import java.util.List;
import java.util.Scanner;

public class DetectAndRemoveCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;
        ListNode temp1 = head, temp2 = head;

        while (n-- > 1) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
            if (n == 4)
                temp1 = temp;
            temp2 = temp;
        }
        temp2.next = temp1;

        removeCycle(head);
        printLinkedList(head);
    }

    private static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    private static void removeCycle(ListNode head) {
        ListNode temp = head;
        ListNode last = findLastOfCycle(temp);
        if (last != null) {
            last.next = null;
        }
    }

    private static ListNode findLastOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow == fast)
            fast = head;
        while (slow != fast) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        return prev;
    }
}
