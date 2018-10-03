package io.octoprime.algo.ds.list.singly;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * implemenation of Queue using FIFO principles of generic items.
 * <p>
 * Based on @Author Robert Sedgewick and @Author Kevin Wayne
 *
 * @param <E>
 */
public class Queue<E> implements Iterable<E> {

    private Node<E> front;    // beginning of queue
    private Node<E> back;     // end of queue
    private int size;               // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty queue.
     */
    public Queue() {
        front = null;
        back = null;
        size = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() {
        return size;
    }

    /**
     * Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return front.item;
    }

    /**
     * Adds the e to this queue.
     *
     * @param item the e to add
     */
    public void enqueue(E item) {

        Node<E> temp = back;
        back = new Node<E>();
        back.item = item;
        back.next = null;

        if (isEmpty()) front = back;
        else temp.next = back;

        size++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public E dequeue() {

        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        E item = front.item;
        front = front.next;
        size--;

        if (isEmpty()) back = null;   // to avoid loitering

        return item;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {

        StringBuilder s = new StringBuilder();
        for (E e : this) {
            s.append(e);
            s.append(' ');
        }
        return s.toString();

    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<E> iterator() {
        return new ListIterator<E>(front);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    /**
     * Unit tests the {@code Queue} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();

        System.out.println("Hello World.");
    }
}
