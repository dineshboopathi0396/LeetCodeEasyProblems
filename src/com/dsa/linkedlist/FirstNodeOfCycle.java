package com.dsa.linkedlist;

import com.leetcode.easy.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNodeOfCycle {

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

        System.out.println(findFirstNodeOfCycle(head));
        System.out.println(findFirstNodeOfCycleApproach2(head));
    }

    private static int findFirstNodeOfCycleApproach2(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (fast != slow)
            return -1;
        fast = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast.val;
    }

    private static int findFirstNodeOfCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();

        ListNode pointer = head;
        while (pointer != null) {
            if (map.containsKey(pointer)) {
                return pointer.val;
            } else {
                map.put(pointer, pointer.val);
            }
            pointer = pointer.next;
        }
        return -1;
    }
}
