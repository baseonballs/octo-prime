package io.octoprime.algo.ds.list;

import java.util.Stack;


/**
 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 * Example:
 * Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
 * Output:  3->2->1->6->5->4->8->7->NULL.
 * <p>
 * Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
 * Output:  5->4->3->2->1->8->7->6->NULL.
 */
public class ReverseKGroups extends UtilsList {

    static Node head;  // head of list

    public static Node reverse(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null)
            head.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }


    public static Node reverseUsingStack(Node head, int k) {
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

        printList(ll.getHead());
        ll.setHead(reverse(ll.getHead(), 3));
        printList(ll.getHead());
    }


    /* Drier program to test above functions */
    public static void main(String args[]) {
        testReversealKGroup();
    }
}
