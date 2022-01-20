package com.leetcode;

import com.dsa.datastructure.linear.linked.LinkedNode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {
        LinkedNode linkedNode3 = new LinkedNode(3, null);
        LinkedNode linkedNode2 = new LinkedNode(4, linkedNode3);
        LinkedNode linkedNode1 = new LinkedNode(2, linkedNode2);

        LinkedNode linkedNode6 = new LinkedNode(9, null);
        LinkedNode linkedNode5 = new LinkedNode(5, linkedNode6);
        LinkedNode linkedNode4 = new LinkedNode(4, linkedNode5);
        LinkedNode result = addTwoNumbers(linkedNode1, linkedNode4);

        List<Integer> list = new ArrayList<>();
        while (result.next != null) {
            list.add(result.val);
            result = result.next;
        }
        list.add(result.val);
        System.out.println(list);
    }

    public static LinkedNode addTwoNumbers(LinkedNode l1, LinkedNode l2) {
        LinkedNode dummyHead = new LinkedNode(0);
        LinkedNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            carry = sum / 10;
            curr.next = new LinkedNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            curr.next = new LinkedNode(carry);
        }
        return dummyHead.next;
    }

}
