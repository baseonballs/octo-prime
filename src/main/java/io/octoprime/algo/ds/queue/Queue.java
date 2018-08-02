package io.octoprime.algo.ds.queue;

// array based implemenation of a queue.
public class Queue {

    private int _capacity;
    int _arr[];
    int _front = 0;
    int _rear = -1;
    int _size = 0;

    public Queue(int queueSize) {
        this._capacity = queueSize;
        _arr = new int[this._capacity];
    }

    /**
     * this method adds element at the end of the queue.
     *
     * @param item
     */
    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: " + item);
        } else {
            _rear++;
            if (_rear == _capacity - 1) {
                _rear = 0;
            }
            _arr[_rear] = item;
            _size++;
            System.out.println("Element " + item + " is pushed to Queue !");
        }
    }

    /**
     * this method removes an element from the top of the queue
     */
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            _front++;
            if (_front == _capacity - 1) {
                System.out.println("Pop operation done ! removed: " + _arr[_front - 1]);
                _front = 0;
            } else {
                System.out.println("Pop operation done ! removed: " + _arr[_front - 1]);
            }
            _size--;
        }
    }

    /**
     * This method checks whether the queue is full or notQueueImpl
     *
     * @return boolean
     */
    public boolean isQueueFull() {
        boolean status = false;
        if (_size == _capacity) {
            status = true;
        }
        return status;
    }

    /**
     * This method checks whether the queue is empty or not
     *
     * @return
     */
    public boolean isQueueEmpty() {
        return (_size == 0) ? true : false;
    }

    public static void main(String a[]) {

        Queue queue = new Queue(4);
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
