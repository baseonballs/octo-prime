package io.octoprime.algo.ds.list;

public class SingleLinkedList {

    class Node {
        //Declare class variables
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    //Class variables for the Linked List
    private static Node head;
    private static int size;

    public SingleLinkedList(Object data) {
        head = new Node(data);
    }

    public void addAtHead(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        size++;
    }

    public void addAtTail(Object data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(data);
        size++;
    }

    public void addAtIndex(int index, Object data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        size++;
    }

    public void deleteAtIndex(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public static int find(Node n) {
        Node t = head;
        int index = 0;
        while (t != n) {
            index++;
            t = t.next;
        }
        return index;
    }

    public static Node find(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static int getSize() {
        return size;
    }

    /**
     * detects if the list has a cycle.
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    /**
     * @param head
     * @return
     */
    public ListNode reverseIter(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        /**
         * fix head node.
         */
        return head = prev;
    }

    /**
     * case1: empty list
     * case2: only one element list
     * case3: reverse from the rest after head
     * reverse between head and head->next
     * finally: unlink list from the rest.
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return prev;
    }


    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        SingleLinkedList ll = new SingleLinkedList(10);
        ll.addAtHead(11);
        ll.addAtHead(12);
        ll.addAtHead(13);
        ll.addAtTail(8);
        ll.addAtTail(7);
        ll.addAtIndex(4, 9);
        ll.addAtIndex(4, 9);
        ll.deleteAtIndex(4);
        printList();
    }
}
