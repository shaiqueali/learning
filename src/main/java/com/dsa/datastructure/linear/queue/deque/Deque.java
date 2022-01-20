package com.dsa.datastructure.linear.queue.deque;

/**
 * Deque or Double Ended Queue is a type of queue in which insertion and removal of elements can either be performed from the front or the rear.
 *
 * Types of Deque
 *  - Input Restricted Deque
 *    In this deque, input is restricted at a single end but allows deletion at both the ends.
 *  - Output Restricted Deque
 *    In this deque, output is restricted at a single end but allows insertion at both the ends.
 *
 *    -----------------------------------------------------------------------------
 *    |  Time Complexity                                                          |
 *    |  The time complexity of all the above operations is constant i.e. O(1)    |
 *    |----------------------------------------------------------------------------
 *
 *  Applications of Deque Data Structure
 *  - In undo operations on software.
 *  - To store history in browsers.
 *  - For implementing both stacks and queues.
 */
// Deque implementation in Java
public class Deque {
    static final int MAX = 100;
    int arr[];
    int front;
    int rear;
    int size;

    public Deque(int size) {
        arr = new int[MAX];
        front = -1;
        rear = 0;
        this.size = size;
    }

    /**
     * This operation checks if the deque is full. If front = 0 and rear = n - 1 OR front = rear + 1, the deque is full.
     */
    boolean isFull() {
        return ((front == 0 && rear == size - 1) || front == rear + 1);
    }

    /**
     * This operation checks if the deque is empty. If front = -1, the deque is empty.
     */
    boolean isEmpty() {
        return (front == -1);
    }

    /**
     * Insert at the Front
     * 1 . Check the position of front.
     * 2 . If front < 1, reinitialize front = n-1 (last index).
     * 3 . Else, decrease front by 1.
     * 4 . Add the new key 5 into array[front].
     */
    void insertFront(int key) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        }

        else if (front == 0)
            front = size - 1;

        else
            front = front - 1;

        arr[front] = key;
    }

    /**
     * Insert at the Rear
     * 1 . Check if the array is full.
     * 2 . If the deque is full, reinitialize rear = 0.
     * 3 . Else, increase rear by 1.
     * 4 . Add the new key 5 into array[rear].
     */
    void insertRear(int key) {
        if (isFull()) {
            System.out.println(" Overflow ");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        }

        else if (rear == size - 1)
            rear = 0;

        else
            rear = rear + 1;

        arr[rear] = key;
    }

    /**
     * Delete from the Front
     *
     * The operation deletes an element from the front.
     *
     * 1 . Check if the deque is empty.
     * 2. If the deque is empty (i.e. front = -1), deletion cannot be performed (underflow condition).
     * 3. If the deque has only one element (i.e. front = rear), set front = -1 and rear = -1.
     * 4. Else if front is at the end (i.e. front = n - 1), set go to the front front = 0.
     * 5. Else, front = front + 1
     */
    void deleteFront() {
        if (isEmpty()) {
            System.out.println("Queue Underflow\n");
            return;
        }

        // Deque has only one element
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1)
            front = 0;

        else
            front = front + 1;
    }

    /**
     * Delete from the Rear
     * 1 . Check if the deque is empty.
     * 2 . If the deque is empty (i.e. front = -1), deletion cannot be performed (underflow condition).
     * 3 . If the deque has only one element (i.e. front = rear), set front = -1 and rear = -1, else follow the steps below.
     * 4 . If rear is at the front (i.e. rear = 0), set go to the front rear = n - 1.
     * 5 . Else, rear = rear - 1
     */

    void deleteRear() {
        if (isEmpty()) {
            System.out.println(" Underflow");
            return;
        }

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0)
            rear = size - 1;
        else
            rear = rear - 1;
    }

    int getFront() {
        if (isEmpty()) {
            System.out.println(" Underflow");
            return -1;
        }
        return arr[front];
    }

    int getRear() {
        if (isEmpty() || rear < 0) {
            System.out.println(" Underflow\n");
            return -1;
        }
        return arr[rear];
    }

    public static void main(String[] args) {

        Deque dq = new Deque(4);

        System.out.println("Insert element at rear end : 12 ");
        dq.insertRear(12);

        System.out.println("insert element at rear end : 14 ");
        dq.insertRear(14);

        System.out.println("get rear element : " + dq.getRear());

        dq.deleteRear();
        System.out.println("After delete rear element new rear become : " + dq.getRear());

        System.out.println("inserting element at front end");
        dq.insertFront(13);

        System.out.println("get front element: " + dq.getFront());

        dq.deleteFront();

        System.out.println("After delete front element new front become : " + +dq.getFront());

    }
}