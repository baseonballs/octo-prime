package io.octoprime.algo.ds.list;

public class ReverseList extends UtilsList {

    public static Node reverse(Node head) {
        if (head == null || head.next == null) return head;

        Node prev = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return prev;
    }

    public static Node reversei(Node head) {

        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return head = prev;
    }


    public static Node reverseBetween(Node head, int m, int n) {
        if (m == n) return head;

        Node prev = null;//track (m-1)th node
        Node first = new Node(0);//first's next points to mth
        Node second = new Node(0);//second's next points to (n+1)th

        int i = 0;
        Node p = head;
        while (p != null) {
            i++;
            if (i == m - 1) {
                prev = p;
            }

            if (i == m) {
                first.next = p;
            }

            if (i == n) {
                second.next = p.next;
                p.next = null;
            }

            p = p.next;
        }
        if (first.next == null)
            return head;

        // reverse list [m, n]
        Node p1 = first.next;
        Node p2 = p1.next;
        p1.next = second.next;

        while (p1 != null && p2 != null) {
            Node t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        //connect to previous part
        if (prev != null)
            prev.next = p1;
        else
            return p1;

        return head;
    }


    public static void testReversealKGroup() {
        SingleLinkedList ll = new SingleLinkedList();

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */

        ll.push(9);
        ll.push(8);
        ll.push(7);
        ll.push(6);
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);

        printList(ll.getHead(), "Before list");
        ll.setHead(reverse(ll.getHead()));
        printList(ll.getHead(), "After list");
    }

    public static void main(String[] args) {

        testReversealKGroup();
    }

}
