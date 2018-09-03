package io.octoprime.algo.ds.array;

/**
 * Array based implementation of a queue.
 */
public class QueueArray {
    int front, rear, size;
    int capacity;
    int array[];

    public QueueArray(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    /**
     * Queue is full when size becomes equal to the capacity
     *
     * @return
     */
    boolean isFull() {
        return (size == capacity - 1);
    }

    /**
     * Queue is empty when size is 0
     *
     * @return
     */
    boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Method to add an item to the queue. It changes rear and size
     *
     * @param item
     */
    void enqueue(int item) {
        if (isFull())
            return;
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size++;
        System.out.println(item + " enqueued to queue");
    }

    /**
     * Method to remove an item from queue. It changes front and size
     *
     * @return
     */
    int dequeue() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return item;
    }

    /**
     * Method to get front of queue
     *
     * @return
     */
    public int peekFront() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return this.array[this.front];
    }

    /**
     * Method to get rear of queue
     *
     * @return
     */
    public int peekRear() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return this.array[this.rear];
    }

    public static void main(String a[]) {

        QueueArray queue = new QueueArray(4);
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(56);
        queue.enqueue(2);
        queue.enqueue(67);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(24);
        queue.dequeue();
        queue.enqueue(98);
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(435);
    }

}
