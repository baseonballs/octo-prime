package io.octoprime.algo.ds.list;

public class PalidromeLinkedList {
    Node left;

    public boolean isPalindrome(Node head) {
        left = head;

        boolean result = helper(head);
        return result;
    }

    public boolean helper(Node right) {

        //stop recursion
        if (right == null)
            return true;

        //if sub-list is not palindrome,  return false
        boolean x = helper(right.next);
        if (!x)
            return false;

        //current left and right
        boolean y = (left.value == right.value);

        //move left to next
        left = left.next;

        return y;
    }


    /*
    Given a singly linked list, determine if it is a palindrome.
    We can create a new list in reversed order and then compare each node. The time and space are O(n).
     */
    public boolean isPalindrome1(Node head) {
        if (head == null)
            return true;

        Node p = head;
        Node prev = new Node(head.value);

        while (p.next != null) {
            Node temp = new Node(p.next.value);
            temp.next = prev;
            prev = temp;
            p = p.next;
        }

        Node p1 = head;
        Node p2 = prev;

        while (p1 != null) {
            if (p1.value != p2.value)
                return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    /*
    We can use a fast and slow pointer to get the center of the list, then reverse the second list
    and compare two sublists. The time is O(n) and space is O(1).
     */
    public boolean isPalindrome2(Node head) {

        if (head == null || head.next == null)
            return true;

        //find list center
        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node secondHead = slow.next;
        slow.next = null;

        //reverse second part of the list
        Node p1 = secondHead;
        Node p2 = p1.next;

        while (p1 != null && p2 != null) {
            Node temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        secondHead.next = null;

        //compare two sublists now
        Node p = (p2 == null ? p1 : p2);
        Node q = head;
        while (p != null) {
            if (p.value != q.value)
                return false;

            p = p.next;
            q = q.next;

        }

        return true;
    }
}
