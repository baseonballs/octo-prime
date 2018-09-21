package io.octoprime.algo.ds.list;

import io.octoprime.algo.ds.list.DoublyLinkedList.Node;

public class MergeSortedDoublyLinkedList {

    Node head;

    /**
     * Function to merge two linked lists
     *
     * @param first
     * @param second
     * @return
     */
    static Node merge(Node first, Node second) {
        // If first linked list is empty
        if (first == null) {
            return second;
        }

        // If second linked list is empty
        if (second == null) {
            return first;
        }

        // Pick the smaller value
        if (first.value < second.value) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList listA = new DoublyLinkedList();
        listA.push(11);
        listA.push(9);
        listA.push(7);
        listA.push(5);
        listA.push(3);
        listA.push(1);


        DoublyLinkedList listB = new DoublyLinkedList();
        listB.push(20);
        listB.push(18);
        listB.push(14);
        listB.push(12);
        listB.push(10);
        listB.push(8);
        listB.push(6);
        listB.push(4);
        listB.push(2);

        // node = list.merge(list, B);
        System.out.println("Linked listA before sorting :");
        listA.iterateForward();
        System.out.println("Linked listB before sorting :");
        listB.iterateForward();

        Node merged = merge(listA.getHead(), listB.getHead());
        listB.print(merged);
    }


    void print(Node node) {
        Node temp = node;
        System.out.println("Forward Traversal using next pointer");
        while (node != null) {
            System.out.print(node.value + " ");
            temp = node;
            node = node.next;
        }
        System.out.println("\nBackward Traversal using prev pointer");
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.prev;
        }
    }

}
