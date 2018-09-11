package io.octoprime.algo.ds.list;

public class ZSandbox {


    public static void main(String[] args) {
        Node head = null;

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = prev;
        }

        head = prev;
        // return ;

    }
}
