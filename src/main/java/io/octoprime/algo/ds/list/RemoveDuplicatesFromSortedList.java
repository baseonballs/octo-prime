package io.octoprime.algo.ds.list;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * <p>
 * Analysis:
 * <p>
 * The key of this problem is using the right loop condition. And change what is necessary in each loop.
 * You can use different iteration conditions like the following 2 solutions.
 * Solution 1
 */
public class RemoveDuplicatesFromSortedList {

    public Node deleteDuplicates(Node head) {
        if (head == null || head.next == null)
            return head;

        Node prev = head;
        Node p = head.next;

        while (p != null) {
            if (p.value == prev.value) {
                prev.next = p.next;
                p = p.next;
                //no change prev
            } else {
                prev = p;
                p = p.next;
            }
        }

        return head;
    }


    public Node deleteDuplicates2(Node head) {
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
}


