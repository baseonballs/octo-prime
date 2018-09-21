package io.octoprime.algo.ds.list;

/**
 * Node object used by  singly linked list;
 */
class DNode {

    int key;
    DNode next;
    DNode prev;

    /**
     * constructor for the DNode
     *
     * @param key the ndoe's value
     */
    DNode(int key) {
        this.key = key;
        next = prev = null;
    }
}
