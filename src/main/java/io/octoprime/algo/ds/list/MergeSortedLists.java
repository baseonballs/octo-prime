package io.octoprime.algo.ds.list;

public class MergeSortedLists {

    public Node mergeTwoSortedLists(Node alist, Node blist) {
        Node head = new Node(0);
        Node t = head;

        while (alist != null || blist != null) {
            if (alist != null && blist != null) {
                if (alist.value < blist.value) {
                    t.next = alist;
                    alist = alist.next;
                } else {
                    t.next = blist;
                    blist = blist.next;
                }
                t = t.next;
            } else if (alist == null) {
                t.next = blist;
                break;
            } else if (blist == null) {
                t.next = alist;
                break;
            }
        }
        return head.next;
    }

}
