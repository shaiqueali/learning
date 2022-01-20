package com.dsa.datastructure.linear.linked;

/**
 * Problem: How do you find the 3rd node from the tail in a single list in one pass, which means you cannot traverse the list twice.
 *
 * Solution: We will use the two pointer approach, one is fast, and the other is slow.
 * The slow pointer starts when fast is pointing to the kth element from the beginning.
 * this way, when the fast pointer reaches or points to the tail of the linked list, the slow pointer would be pointing to the kth element from the tail.
 *
 * How to find 2nd, 3rd or kth element from end in a singly linked list
 * Java Program to find nth node from tail in linked list
 *
 */
public class KthNodeFromLastInLinkedList {

    public static void main(String a[]) {
        LinkedNode ten = new LinkedNode(10);
        LinkedNode twenty = new LinkedNode(20);
        LinkedNode thirty = new LinkedNode(30);
        LinkedNode forty = new LinkedNode(40);
        LinkedNode fifty = new LinkedNode(50);
        LinkedNode sixty = new LinkedNode(60);
        LinkedNode head = ten;
        head.next = twenty;
        twenty.next = thirty;
        thirty.next = forty;
        forty.next = fifty;
        fifty.next = sixty;
        // Now our linked list is  // 10 > 20 > 30 > 40 > 50 > 60 > null
        System.out.println("2nd element from end in linked list : " + getNthNodeFromEnd(head, 2));
        System.out.println("3rd element from tail in linked list : " + getNthNodeFromEnd(head, 3));
        System.out.println("4th element from end in linked list : " + getNthNodeFromEnd(head, 4));
    }

    /*  * return nth node from tail of linked list  */
    public static LinkedNode getNthNodeFromEnd(LinkedNode head, int n) {
        LinkedNode fast = head;
        LinkedNode slow = head;
        int count = 1;
        // let's move fast pointer to n step ahead
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        // now let's start moving both fast and slow pointer
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
