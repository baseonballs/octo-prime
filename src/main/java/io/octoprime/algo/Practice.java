package io.octoprime.algo;

import io.octoprime.algo.strings.UtilsString;

public class Practice {

    public class BST {
        Node _root;

        public Node getRoot() {
            return _root;
        }

        public void insert(int key) {
            insertNode(_root, key);
        }

        private Node insertNode(Node node, int key) {
            if (node == null) return null;

            if (key < node.key)
                node.left = insertNode(node.left, key);
            if (key > node.key)
                node.right = insertNode(node.right, key);

            return node;
        }

        void delete() {

        }

        public Node delete(Node n, int key) {
            if (n == null) return null;

            if (key < n.key)
                n.left = delete(n.left, key);
            else if (key > n.key)
                n.right = delete(n.right, key);

            // we have the node; let deal with use case
            if (n.left == null)
                return n.right;
            else if (n.right == null)
                return n.left;

            // update the in order succesor
            // n.key = min( n.right, key );
            n.right = delete(n.right, n.key);

            return n;
        }

        public int min(Node n) {
            if (n == null) return Integer.MIN_VALUE;

            int min = n.key;
            while (n.left != null) {
                min = n.key;
                n = n.left;
            }

            return min;
        }

        public Node find(Node n, int key) {
            if (n == null) return null;

            if (key < n.key) return find(n.left, key);
            else if (key > n.key) return find(n.right, key);

            return n;
        }
    }

    class Node {
        int key;
        Node left;
        Node right;


        Node(int key) {
            left = right = null;
            this.key = key;
        }
    }

    public static void easy1ReverseString() {
        System.out.println("Easy #1: ");
        System.out.println("---------");
        String s = "hello";
        System.out.println("source string: " + s);
        System.out.println("reverse string: " + UtilsString.reverseString(s));

    }


    public static void main(String[] args) {
        int x = 1028;

        System.out.println("Value is :" + x);
        // easy1ReverseString();

        boolean isPowerOfTwo = ((x & (x - 1)) == 0);
        System.out.println("Is Power of 2: " + (isPowerOfTwo ? "true" : "false"));

        //  easy2SumOfTarget(5);
    }
}
