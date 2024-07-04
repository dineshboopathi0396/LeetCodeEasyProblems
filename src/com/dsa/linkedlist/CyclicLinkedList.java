package com.dsa.linkedlist;

import com.leetcode.easy.ListNode;

import java.util.Scanner;

public class CyclicLinkedList {
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
//        temp2.next = temp1;

        System.out.println(isCyclic(head));
    }

    private static boolean isCyclic(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
