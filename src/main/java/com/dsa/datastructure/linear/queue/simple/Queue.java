package com.dsa.datastructure.linear.queue.simple;

import java.util.Arrays;

public class Queue {
    private final int size;
    private final int[] items;
    private int front;
    private int rear;

    public Queue(final int size) {
        this.size = size;
        items = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    public void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear++;
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    public int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return front;
        } else {
            element = items[front];
            items[front] = 0;
            /* Q has only one element, so we reset the queue after deleting it. */
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println("Deleted -> " + element);
            return (element);
        }
    }

    public void display() {
        /* Function to display elements of Queue */
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("\nFront index-> " + front);
            System.out.println("Items -> ");
            for (int i = front; i <= rear; i++)
                System.out.println("index[" + i + "], value[" +  items[i] + "]");

            System.out.println(Arrays.toString(items));
            System.out.println("\nRear index-> " + rear);
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        // deQueue is not possible on empty queue
        q.deQueue();

        // enQueue 5 elements
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // 6th element can't be added to because the queue is full
        q.enQueue(6);

        q.display();

        // deQueue removes element entered first i.e. 1
        q.deQueue();
        q.deQueue();
        q.deQueue();

        // Now we have just 4 elements
        q.display();

    }
}
