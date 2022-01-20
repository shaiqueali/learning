package com.dsa.datastructure.linear.linked;

public class LinkedNode {

    public int val;

    public LinkedNode next;

    public LinkedNode(int val) {
        this.val = val;
    }

    public LinkedNode(int val, LinkedNode next) {
        this.val = val;
        this.next = next;
    }
}
