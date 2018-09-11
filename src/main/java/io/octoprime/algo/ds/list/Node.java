package io.octoprime.algo.ds.list;

/**
 * Node object used by  singly linked list;
 */
public class Node {

    int value;
    Node next;

    /**
     * @param value the ndoe's value
     */
    public Node(int value) {
        this.value = value;
        next = null;
    }
}
