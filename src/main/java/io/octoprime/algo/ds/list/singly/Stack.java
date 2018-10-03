package io.octoprime.algo.ds.list.singly;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implemenation of Queue using LIFO principles of generic items.
 * <p>
 * Based on @Author Robert Sedgewick and @Author Kevin Wayne
 *
 * @param <E>
 */
public class Stack<E> {

    private Node<E> head;     // top of stack
    private int size;                // size of the stack

    // helper linked list class
    private static class Node<E> {
        private E item;
        private Node<E> next;
    }

    /**
     * Initializes an empty stack.
     */
    public Stack() {
        head = null;
        size = 0;
    }

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    public int size() {
        return size;
    }

    /**
     * Adds the item to this stack.
     *
     * @param item the item to add
     */
    public void push(E item) {
        Node<E> temp = head;
        head = new Node<E>();
        head.item = item;
        head.next = temp;
        size++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        E item = head.item;        // save item to return
        head = head.next;            // delete head node
        size--;
        return item;                   // return the saved item
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return head.item;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in this stack in LIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        //  for (E item : this) {
        //      s.append(item);
        //     s.append(' ');
        //  }
        return s.toString();
    }


    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    public Iterator<E> iterator() {
        return new ListIterator<E>(head);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> curr;

        public ListIterator(Node<Item> head) {
            curr = head;
        }

        public boolean hasNext() {
            return curr != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        System.out.println("Hello World");
    }
}
