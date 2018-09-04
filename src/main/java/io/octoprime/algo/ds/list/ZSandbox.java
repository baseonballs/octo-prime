package io.octoprime.algo.ds.list;

public class ZSandbox {


    public static void main(String[] args) {
        ListNode head = null;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = prev;
        }

        head = prev;
        // return ;

    }
}
