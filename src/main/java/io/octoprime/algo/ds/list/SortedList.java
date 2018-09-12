package io.octoprime.algo.ds.list;

public class SortedList {

    public Node mergeTwoSortedLists(Node l1, Node l2) {
        Node head = new Node(0);
        Node p = head;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.value < l2.value) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            } else if (l1 == null) {
                p.next = l2;
                break;
            } else if (l2 == null) {
                p.next = l1;
                break;
            }
        }
        return head.next;
    }

}
