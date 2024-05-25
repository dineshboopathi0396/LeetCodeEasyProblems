package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class LinkedListInsertion {
    public ListNode findInsertion(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }
}
