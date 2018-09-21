package io.octoprime.algo.ds.list;

import static io.octoprime.algo.ds.list.UtilsList.printList;

public class SingleLinkedList {

    private Node _head;
    private int _size;

    public Node getHead() {
        return _head;
    }

    public void setHead(Node h) {
        _head = h;
    }

    public void addFront(int value) {
        Node temp = _head;
        _head = new Node(value);
        _head.next = temp;
        _size++;
    }

    /**
     * Appends the specified value to the end of the list; Essentially the facade tot he addBack method.
     *
     * @param value
     */
    public void add(int value) {
        addBack(value);
    }

    /**
     * add the value to the front of the list. Essentially the facade tot he addFront method.
     *
     * @param value
     */
    public void push(int value) {
        addFront(value);
    }


    public void addBack(int value) {
        Node temp = _head;

        if (_head == null) {
            addFront(value);
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(value);
            _size++;
        }
    }

    public void addAtIndex(int index, int value) {
        Node temp = _head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(value);
        temp.next.next = holder;
        _size++;
    }

    public void deleteAtIndex(int index) {
        Node temp = _head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        _size--;
    }

    public int find(Node n) {
        Node t = _head;
        int index = 0;
        while (t != n) {
            index++;
            t = t.next;
        }
        return index;
    }

    public Node find(int index) {
        Node temp = _head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    public int getSize() {
        return _size;
    }

    /**
     * detects if the list has a cycle.
     *
     * @param head
     * @return
     */
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }


    public Node deleteDuplicatesFromSortedList(Node head) {
        if (head == null || head.next == null)
            return head;

        Node p = head;

        while (p != null && p.next != null) {
            if (p.value == p.next.value) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return head;
    }

    /*
    Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are
    talking about the node number and not the value in the nodes.
    The program should run in O(1) space complexity and O(nodes) time complexity.
     */
    public Node groupByOddsEvens(Node head) {
        if (head == null)
            return head;

        Node result = head;
        Node p1 = head;
        Node p2 = head.next;
        Node connectNode = head.next;

        while (p1 != null && p2 != null) {
            Node t = p2.next;
            if (t == null)
                break;

            p1.next = p2.next;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }

        p1.next = connectNode;

        return result;
    }

    public static void testLinkedList() {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        SingleLinkedList ll = new SingleLinkedList();
        ll.addFront(11);
        ll.addFront(12);
        ll.addFront(13);
        ll.addBack(8);
        ll.addBack(7);
        ll.addAtIndex(4, 9);
        ll.addAtIndex(4, 9);
        ll.deleteAtIndex(4);
        printList(ll.getHead());
    }

    public static void main(String[] args) {
        testLinkedList();
    }
}
