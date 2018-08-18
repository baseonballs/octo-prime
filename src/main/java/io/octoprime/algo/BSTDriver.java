package io.octoprime.algo;

import io.octoprime.AbstractUtils;


public class BSTDriver extends AbstractUtils {

    static class BST {
        class Node {
            int key;
            Node left, right;

            Node(int key) {
                this.key = key;
                left = right = null;
            }
        }

        Node _root;

        public Node getRoot() {
            return _root;
        }

        public Node insert(int key) {
            return _root = insert(getRoot(), key);
        }

        private Node insert(Node n, int key) {
            if (n == null)
                return new Node(key);
            if (key < n.key)
                n.left = insert(n.left, key);
            else
                n.right = insert(n.right, key);

            return n;
        }

        public int min(Node n) {
            //Node n = getRoot();
            if (n == null) return -1;

            int min = n.key;
            while (n.left != null) {
                min = n.left.key;
                n = n.left;
            }

            return min;
        }


        public int max() {
            Node n = getRoot();

            int max = n.key;
            while (n.right != null) {
                max = n.right.key;
                n = n.right;
            }

            return max;
        }

        public void printInOrder(Node n) {
            if (n != null) {
                printInOrder(n.left);
                System.out.print(n.key + " ");
                printInOrder(n.right);
            }
        }

        public int height(Node n) {
            if (n == null) return 0;
            int lf = height(n.left);
            int rt = height(n.right);
            return Math.max(lf, rt) + 1;
        }

        public Node delete(Node n, int key) {
            if (n == null) return n;

            if (key < n.key)
                n.left = delete(n.left, key);
            else if (key > n.key)
                n.right = delete(n.right, key);
            else {
                if (n.left == null) return n.right;
                else if (n.right == null) return n.left;

                n.key = min(n.right);

                n.right = delete(n.right, key);

            }

            return n;
        }
    }

    public static void main(String[] arg) {

        BST bst = new BST();

                /* Let us create following BinarySearchTree
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        bst.printInOrder(bst.getRoot());

        System.out.println("\nThe min value in tree is: " + bst.min(bst.getRoot()));
        System.out.println("\nThe max value in tree is: " + bst.max());
        System.out.println("\nThe height of tree is: " + bst.height(bst.getRoot()));

        System.out.println(String.format("delete value %d: ", 80));

        bst.delete(bst.getRoot(), 80);

        System.out.println("\nThe max value in tree is: " + bst.max());
        System.out.println("\nThe height of tree is: " + bst.height(bst.getRoot()));
    }

}
