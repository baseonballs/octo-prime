package io.octoprime.algo.ds.cache;

import java.util.HashMap;
public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            addFront(n);
            return n.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            addFront(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
                addFront(created);
            } else {
                addFront(created);
            }
            map.put(key, created);
        }
    }

    public void remove(Node n) {
        if (n.prev != null) {
            n.prev.next = n.next;
        } else {
            head = n.next;
        }
        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            tail = n.prev;
        }
    }

    public void addFront(Node n) {
        n.next = head;
        n.prev = null;
        if (head != null)
            head.prev = n;
        head = n;
        if (tail == null)
            tail = head;
    }
}
