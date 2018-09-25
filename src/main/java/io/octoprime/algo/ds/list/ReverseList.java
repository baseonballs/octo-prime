package io.octoprime.algo.ds.list;

public class ReverseList extends UtilsList {

    public static Node reverser(Node head) {
        if (head == null || head.next == null) return head;

        Node prev = reverser(head.next);

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

    /**
     * Strategy:
     * find index referenced by m and n;
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static Node reverseb(Node head, int m, int n) {
        if (m == n) return head;

        Node prev = null;//track (m-1)th node
        Node listA = new Node(0);//first's next points to mth
        Node listB = new Node(0);//second's next points to (n+1)th

        int i = 0;
        Node curr = head;
        while (curr != null) {
            i++;
            if (i == m - 1) {
                prev = curr;
            }

            if (i == m) {
                listA.next = curr;
            }

            if (i == n) {
                listB.next = curr.next;
                curr.next = null;
            }

            curr = curr.next;
        }
        if (listA.next == null)
            return head;

        /**
         * Reverse the actual between lists [ m, n ]
         */
        Node p1 = listA.next;
        Node p2 = p1.next;
        p1.next = listB.next;

        while (p1 != null && p2 != null) {
            Node t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        /**
         * Rewire to previous part
         */
        if (prev != null)
            prev.next = p1;
        else
            return p1;

        return head;
    }


    public static void testReverseaRecursion() {
        SingleLinkedList ll = new SingleLinkedList();

        /* Constructed Linked List is 1->2->3->4->5->6->7->8->9->null */

        ll.push(9);
        ll.push(8);
        ll.push(7);
        ll.push(6);
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);

        System.out.println("--------------------------------------");
        System.out.println(">>>>>> Reverse Using Recursion <<<<<<<");
        System.out.println("--------------------------------------");

        printList(ll.getHead(), "Before list");
        ll.setHead(reverser(ll.getHead()));
        printList(ll.getHead(), "After list");
        System.out.println();

    }

    public static void testReverseaIteration() {
        SingleLinkedList ll = new SingleLinkedList();

        /* Constructed Linked List is 1->2->3->4->5->6->7->8->9->null */


        ll.push(9);
        ll.push(8);
        ll.push(7);
        ll.push(6);
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);

        System.out.println("--------------------------------------");
        System.out.println(">>>>>> Reverse Using Iteration <<<<<<<");
        System.out.println("--------------------------------------");
        printList(ll.getHead(), "Before list");
        ll.setHead(reversei(ll.getHead()));
        printList(ll.getHead(), "After list");
        System.out.println();
    }


    public static void testReverseaBetween() {
        SingleLinkedList ll = new SingleLinkedList();

        /* Constructed Linked List is 1->2->3->4->5->6->7->8->9->null */

        ll.push(9);
        ll.push(8);
        ll.push(7);
        ll.push(6);
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);

        System.out.println("--------------------------------------");
        System.out.println(">>>>>>  Reverse Using Between  <<<<<<<");
        System.out.println("--------------------------------------");
        printList(ll.getHead(), "Before list");
        ll.setHead(reverseb(ll.getHead(), 4, 6));
        printList(ll.getHead(), "After list");
        System.out.println();
    }

    public static void main(String[] args) {

        testReverseaRecursion();
        testReverseaIteration();
        testReverseaBetween();
    }

}
