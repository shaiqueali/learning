package com.dsa.datastructure.linear.queue.circular;

public class CQueue {
    private final int size;
    private final int[] items;
    private int front;
    private int rear;

    CQueue(final int size) {
        this.size = size;
        items = new int[size];
        front = -1;
        rear = -1;
    }

    // Check if the queue is full
    boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        // Case 2: FRONT = REAR + 1
        /**
         * The second case happens when REAR starts from 0 due to circular increment and when its value is just 1 less than FRONT, the queue is full.
         */
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    // Check if the queue is empty
    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    // Adding an element
    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % size;
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    // Removing an element
    int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        } else {
            element = items[front];
            if (front == rear) { /* Q has only one element, so we reset the queue after deleting it. */
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return (element);
        }
    }

    void display() {
        /* Function to display status of Circular Queue */
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front -> " + front);
            System.out.println("Items -> ");
            for (i = front; i != rear; i = (i + 1) % size)
                System.out.print(items[i] + " ");
            System.out.println(items[i]);
            System.out.println("Rear -> " + rear);
        }
    }

    public static void main(String[] args) {

        CQueue q = new CQueue(5);

        // Fails because front = -1
        q.deQueue();

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // Fails to enqueue because front == 0 && rear == SIZE - 1
        q.enQueue(6);

        q.display();

        int elem = q.deQueue();

        if (elem != -1) {
            System.out.println("Deleted Element is " + elem);
        }
        q.display();

        q.enQueue(7);

        q.display();

        // Fails to enqueue because front == rear + 1
        q.enQueue(8);
    }
}
