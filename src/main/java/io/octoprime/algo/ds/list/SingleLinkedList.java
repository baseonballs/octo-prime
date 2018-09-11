package io.octoprime.algo.ds.list;

import java.util.Stack;

public class SingleLinkedList {

    private static Node head;
    private static int size;

    public SingleLinkedList(int value) {
        head = new Node(value);
    }

    public Node getHead() {
        return head;
    }

    public void addAtHead(int value) {
        Node temp = head;
        head = new Node(value);
        head.next = temp;
        size++;
    }

    public void addAtTail(int value) {
        Node temp = head;

        if (head == null) {
            addAtHead(value);
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(value);
            size++;
        }
    }

    public void addAtIndex(int index, int value) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(value);
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
            System.out.print(temp.value + ", ");
            temp = temp.next;
        }
        System.out.println();
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

    public Node reverse(Node head) {
        if (head == null || head.next == null) return head;

        Node prev = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return prev;
    }

    public Node reversei(Node head) {

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

    public static Node reverseKGroup(Node head, int k) {
        Stack<Integer> stack = new Stack<Integer>();
        Node index = head;

        while (index != null) {
            Node curr = index;

            while (stack.size() < k && curr != null) {
                stack.push(curr.value);
                curr = curr.next;
            }

            if (stack.size() == k) {

                while (index != null && stack.size() > 0) {
                    index.value = stack.pop();
                    index = index.next;
                }

            } else {
                index = null;
            }
        }

        return head;
    }


    /*
    Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are
    talking about the node number and not the value in the nodes.
    The program should run in O(1) space complexity and O(nodes) time complexity.
     */
    public Node segmentByOddsEvens(Node head) {
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


    public Node findIntersection(Node headA, Node headB) {
        int len1 = 0;
        int len2 = 0;
        Node p1 = headA, p2 = headB;
        if (p1 == null || p2 == null)
            return null;

        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }

        int diff = 0;
        p1 = headA;
        p2 = headB;

        if (len1 > len2) {
            diff = len1 - len2;
            int i = 0;
            while (i < diff) {
                p1 = p1.next;
                i++;
            }
        } else {
            diff = len2 - len1;
            int i = 0;
            while (i < diff) {
                p2 = p2.next;
                i++;
            }
        }

        while (p1 != null && p2 != null) {
            if (p1.value == p2.value) {
                return p1;
            } else {

            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }


    public static void testReversealKGroup() {
        SingleLinkedList ll = new SingleLinkedList(10);

        ll.addAtHead(3);
        ll.addAtTail(12);
        ll.addAtHead(2);
        ll.addAtTail(6);
        ll.addAtTail(9);

        printList();

        reverseKGroup(ll.getHead(), 3);

        printList();
    }

    public static void testLinkedList() {
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

    public static void main(String[] args) {

        if (false) testLinkedList();
        testReversealKGroup();
    }
}
