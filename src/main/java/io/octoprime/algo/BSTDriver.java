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

        private Node _root;

        public Node insert(int key) {
            return _root = insert(_root, key);
        }

        private Node insert(Node node, int key) {
            if (node == null)
                return new Node(key);

            if (key < node.key)
                node.left = insert(node.left, key);
            else node.right = insert(node.right, key);

            return node;
        }

        public void printInOrder(Node n) {
            if (n != null) {
                printInOrder(n.left);
                System.out.print(n.key + " ");
                printInOrder(n.right);
            }
        }

        public Node getRoot() {
            return _root;
        }

        public int min() {
            Node n = getRoot();

            int key = n.key;
            while (n.left != null) {
                key = n.left.key;
                n = n.left;
            }
            return key;
        }

        int height(Node node) {
            if (node == null)
                return 0;
            else {
                /* compute the depth of each subtree */
                int lDepth = height(node.left);
                int rDepth = height(node.right);

                return Math.max(lDepth, rDepth) + 1;
            }
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

        System.out.println("\nThe min value in tree is: " + bst.min());
        System.out.println("\nThe max value in tree is: " + bst.max());
        System.out.println("\nThe height of tree is: " + bst.height(bst.getRoot()));

    }

}
