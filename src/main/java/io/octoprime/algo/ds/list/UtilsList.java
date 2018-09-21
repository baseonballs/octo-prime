package io.octoprime.algo.ds.list;

public class UtilsList {

    public static void printList(Node head, String... s) {

        Node temp = head;

        if (s[0] != null)
            System.out.print(s[0] + " : [");

        while (temp != null) {
            System.out.print(temp.value + (temp.next == null ? "" : ", "));
            temp = temp.next;
        }
        System.out.println("]");
    }
}
