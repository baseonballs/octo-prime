package io.octoprime.algo.ds.list;

/**
 * Node object used by  singly linked list;
 */
class DListNode {

    int key;
    DListNode next;
    DListNode prev;

    /**
     * constructor for the DListNode
     *
     * @param key the ndoe's value
     */
    DListNode(int key) {
        this.key = key;
        next = prev = null;
    }
}
