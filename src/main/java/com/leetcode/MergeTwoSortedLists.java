package com.leetcode;

import com.dsa.datastructure.linear.linked.LinkedNode;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLists {

    public static void main(String args[]) {
        
        LinkedNode linkedNode3 = new LinkedNode(4, null);
        LinkedNode linkedNode2 = new LinkedNode(2, linkedNode3);
        LinkedNode linkedNode1 = new LinkedNode(1, linkedNode2);

        LinkedNode linkedNode6 = new LinkedNode(4, null);
        LinkedNode linkedNode5 = new LinkedNode(3, linkedNode6);
        LinkedNode linkedNode4 = new LinkedNode(1, linkedNode5);

        LinkedNode result = mergeTwoLists(linkedNode1, linkedNode4);

        List<Integer> list = new ArrayList<>();
        while (result.next != null) {
            list.add(result.val);
            result = result.next;
        }
        list.add(result.val);
        System.out.println(list);

    }

    public static LinkedNode mergeTwoLists(LinkedNode l1, LinkedNode l2) {
        LinkedNode dummyH = new LinkedNode(Integer.MAX_VALUE - 1);
        LinkedNode head = dummyH;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) { // l1 is less or equal to l2
                dummyH.next = l1;
                dummyH = dummyH.next;
                l1 = l1.next;
                System.out.println("if - > " + dummyH.val);
            } else {
                dummyH.next = l2;
                dummyH = dummyH.next;
                l2 = l2.next;
                System.out.println("else - > " + dummyH.val);
            }
        }

        dummyH.next = (l1 == null) ? l2 : l1;

        return head.next;

    }

}
