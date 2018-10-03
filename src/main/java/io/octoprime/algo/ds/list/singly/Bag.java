package io.octoprime.algo.ds.list.singly;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * implemenation of bag (or multiset) of generic items.
 * <p>
 * Based on @Author Robert Sedgewick and @Author Kevin Wayne
 *
 * @param <E>
 */
public class Bag<E> implements Iterable<E> {

    private Node<E> head;    // beginning of bag
    private int size;               // number of elements in bag

    // helper linked list class
    private static class Node<E> {
        private E item;
        private Node<E> next;
    }

    public Bag() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void add(E item) {
        Node<E> temp = head;
        head = new Node<E>();
        head.item = item;
        head.next = temp;
        size++;
    }


    /**
     * Returns an iterator that iterates over the items in this bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in this bag in arbitrary order
     */
    public Iterator<E> iterator() {
        return new ListIterator<E>(head);
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

    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();

        System.out.println("Hello World.");
    }

}
