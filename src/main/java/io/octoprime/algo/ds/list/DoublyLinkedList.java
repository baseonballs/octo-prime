package io.octoprime.algo.ds.list;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        size = 0;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }


    /**
     * this class keeps track of each value information
     *
     * @author java2novice
     */
    public class Node {
        int value;
        Node next;
        Node prev;

        public Node(int element, Node next, Node prev) {
            this.value = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * returns the size of the linked list
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * return whether the list is empty or not
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * adds value at the starting of the linked list
     *
     * @param element
     */
    public void addFirst(int element) {
        Node tmp = new Node(element, head, null);
        if (head != null) {
            head.prev = tmp;
        }
        head = tmp;
        if (tail == null) {
            tail = tmp;
        }
        size++;
        System.out.println("adding: " + element);
    }

    public void add(int element) {
        addLast(element);
    }

    public void push(int element) {
        addFirst(element);
    }

    /**
     * adds value at the end of the linked list
     *
     * @param element
     */
    public void addLast(int element) {

        Node tmp = new Node(element, null, tail);
        if (tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if (head == null) {
            head = tmp;
        }
        size++;
        System.out.println("adding: " + element);
    }

    /**
     * this method walks forward through the linked list
     */
    public void iterateForward() {

        System.out.print("Iterating forward: ");
        System.out.print("[");

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + (temp.next == null ? "" : ", "));
            temp = temp.next;
        }

        System.out.println("]");
    }

    public void print(Node head) {

        System.out.print("Iterating forward: ");
        System.out.print("[");

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + (temp.next == null ? "" : ", "));
            temp = temp.next;
        }

        System.out.println("]");
    }


    /**
     * this method walks backward through the linked list
     */
    public void iterateBackward() {

        System.out.print("Iterating backwards: ");
        System.out.println("[");

        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.value + (temp.next == null ? "" : ", "));
            temp = temp.prev;
        }

        System.out.println("]");
    }

    /**
     * this method removes value from the start of the linked list
     *
     * @return
     */
    public int removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: " + tmp.value);
        return tmp.value;
    }

    /**
     * this method removes value from the end of the linked list
     *
     * @return
     */
    public int removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("deleted: " + tmp.value);
        return tmp.value;
    }

    public static void main(String a[]) {

        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(10);
        list.addFirst(34);
        list.addLast(56);
        list.addLast(364);
        list.iterateForward();
        list.removeFirst();
        list.removeLast();
        list.iterateBackward();
    }
}
