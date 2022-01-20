package com.leetcode;

import com.dsa.datastructure.linear.linked.LinkedNode;

public class LinkedListCycle {

    public boolean hasCycle(final LinkedNode head) {
        if (head == null) return false;
        LinkedNode slow = head;
        LinkedNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycle2(final LinkedNode head) {
        if (head == null) return false;
        LinkedNode slow = head;
        LinkedNode fast = head.next;
        while (slow.next != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
