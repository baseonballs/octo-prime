package io.octoprime.algo.ds.list;

/**
 * Solution1 - Non-recursively
 * It would be much easier to reverse an array than a linked list, since array supports random access with index, while singly
 * linked list can ONLY be operated through its head node. So an approach without index is required.
 * Think about how '1->2->3' can become '3->2->1'. Starting from '1', we should turn '1->2' into '2->1', then '2->3' into '3->2',
 * and so on. The key is how to swap two adjacent nodes.
 * temp = head -> next;
 * head->next = prev;
 * prev = head;
 * head = temp;
 * The above code maintains two pointer, prev and head , and keeps record of next node before swapping. More detailed
 * analysis:
 * Reverse Linked List
 * 38
 */
public class ReverseSinglyLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
// fix head
        head = prev;
        return head;
    }


    public ListNode reverse(ListNode head) {
// case1: empty list
        if (head == null) return head;
// case2: only one element list
        if (head.next == null) return head;
// case3: reverse from the rest after head
        ListNode newHead = reverse(head.next);
// reverse between head and head->next
        head.next.next = head;
// unlink list from the rest
        head.next = null;
        return newHead;
    }

}
