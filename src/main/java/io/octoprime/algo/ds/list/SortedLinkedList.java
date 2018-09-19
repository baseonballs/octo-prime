package io.octoprime.algo.ds.list;

public class SortedLinkedList {

    Node head = null;

    Node merge(Node a, Node b) {
        Node temp = null;

        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.value <= b.value) {
            temp = a;
            temp.next = merge(a.next, b);
        } else {
            temp = b;
            temp.next = merge(a, b.next);
        }
        return temp;
    }

    Node sort(Node h) {

        if (h == null || h.next == null) {
            return h;
        }

        // get the middle of the list
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply sort on left list
        Node left = sort(h);

        // Apply sort on right list
        Node right = sort(nextofmiddle);

        // Merge the left and right lists
        Node sortedlist = merge(left, right);
        return sortedlist;
    }

    Node getMiddle(Node h) {
        if (h == null) return h;

        Node fast = h.next;
        Node slow = h;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    void push(int value) {
        Node node = new Node(value);

        node.next = head;
        head = node;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        SortedLinkedList li = new SortedLinkedList();

        /*
         * Let us create a unsorted linked lists to test the functions Created
         * lists shall be a: 2->3->20->5->10->15
         */
        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);
        System.out.println("Linked List without sorting is :");
        li.printList(li.head);

        // Apply merge Sort
        li.head = li.sort(li.head);
        System.out.print("\n Sorted Linked List is: \n");
        li.printList(li.head);
    }

}
