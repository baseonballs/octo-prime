package io.octoprime.algo.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    private Node _root;

    BinarySearchTree() {
        _root = null;
    }

    public Node getRoot() {
        return _root;
    }

    void deleteItem(int key) {
        _root = delete(_root, key);
    }

    Node delete(Node node, int key) {
        /* Base Case: If the tree is empty */
        if (node == null) return node;

        /* Otherwise, recur down the tree */
        if (key < node.key)
            node.left = delete(node.left, key);
        else if (key > node.key)
            node.right = delete(node.right, key);

            // if key is same as _root's key, then This is the node
            // to be deleted
        else {
            // node with only one child or no child
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            // node with two children: Get the inOrderPrint successor (smallest
            // in the right subtree)
            node.key = min(node.right);

            // Delete the inOrderPrint successor
            node.right = delete(node.right, node.key);
        }

        return node;
    }

    int min(Node node) {
        if (node == null) return -1;

        int min = node.key;
        while (node.left != null) {
            min = node.left.key;
            node = node.left;
        }
        return min;
    }

    int max(Node node) {
        if (node == null) return -1;

        int max = node.key;
        while (node.right != null) {
            max = node.right.key;
            node = node.right;
        }

        return max;
    }

    /* Compute the "maxDepth" of a tree -- the number of
      nodes along the longest path from the root node
      down to the farthest leaf node.*/
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


    /* Function to get the maximum width of a binary tree*/
    int getMaxWidth(Node node) {
        int maxWidth = 0;
        int width;
        int h = height(node);
        int i;

        /* Get width of each level and compare
           the width with maximum width so far */
        for (i = 1; i <= h; i++) {
            width = getWidth(node, i);
            if (width > maxWidth)
                maxWidth = width;
        }

        return maxWidth;
    }

    /* Get width of a given level */
    int getWidth(Node node, int level) {
        if (node == null)
            return 0;

        if (level == 1)
            return 1;
        else if (level > 1)
            return getWidth(node.left, level - 1)
                    + getWidth(node.right, level - 1);
        return 0;
    }


    // Function to find the maximum width of
    // the tree using level order traversal

    /**
     * We can use Queue based level order traversal to optimize the time complexity of this method.
     * The Queue based level order traversal will take O(n) time in worst case. Thanks to Nitish, DivyaC and
     * tech.login.id2 for suggesting this optimization. See their comments for implementation using queue-based
     * traversal.
     * <p>
     * Method 2 (Using Level Order Traversal with Queue)
     * In this method we store all the child nodes at the current level in the queue and then count the total
     * number of nodes after the level order traversal for a particular level is completed. Since the queue now
     * contains all the nodes of the next level, we can easily find out the total number of nodes in the next level
     * by finding the size of queue. We then follow the same procedure for the successive levels. We store and update
     * the maximum number of nodes found at each level.
     *
     * @param node
     * @return
     */
    public int maxwidth(Node node) {
        // Base case
        if (node == null)
            return 0;

        // Initialize result
        int maxwidth = 0;

        // Do Level order traversal keeping
        // track of number of nodes at every level
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            // Get the size of queue when the level order
            // traversal for one level finishes
            int count = q.size();

            // Update the maximum node count value
            maxwidth = Math.max(maxwidth, count);

            // Iterate for all the nodes in
            // the queue currently
            while (count-- > 0) {
                // Dequeue an node from queue
                Node temp = q.remove();

                // Enqueue left and right children
                // of dequeued node
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return maxwidth;
    }

    void insert(int key) {
        _root = insertNode(_root, key);
    }

    Node insertNode(Node node, int key) {
        /* If the tree is empty, return a new node */
        if (node == null) {
            node = new Node(key);
            return node;
        }

        /* Otherwise, recur down the tree */
        if (key < node.key)
            node.left = insertNode(node.left, key);
        else if (key > node.key)
            node.right = insertNode(node.right, key);

        /* return the (unchanged) node pointer */
        return node;
    }

    void inOrderPrint() {
        inorderPrint(_root);
    }

    void inorderPrint(Node node) {
        if (node != null) {
            inorderPrint(node.left);
            System.out.print(node.key + " ");
            inorderPrint(node.right);
        }
    }

    void postOrder() {
        postOrderPrint(_root);
    }

    void postOrderPrint(Node node) {
        if (node != null) {
            postOrderPrint(node.left);
            postOrderPrint(node.right);
            System.out.print(node.key + " ");
        }
    }

    void preOrderPrint() {
        preOrderPrint(_root);
    }

    void preOrderPrint(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrderPrint(node.left);
            preOrderPrint(node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BinarySearchTree
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree");
        tree.inOrderPrint();
        System.out.println("\nPreorder traversal of the given tree");
        tree.preOrderPrint();
        System.out.println("\nPostorder traversal of the given tree");
        tree.postOrder();
        System.out.println(String.format("\n\nThe minimum key is:  %d", tree.min(tree.getRoot())));
        System.out.println(String.format("The maximum key is:  %d\n", tree.max(tree.getRoot())));

        tree.deleteItem(20);
        System.out.println("Inorder traversal of the given tree");
        tree.inOrderPrint();
        System.out.println(String.format("\n\nThe minimum key is:  %d", tree.min(tree.getRoot())));
        System.out.println(String.format("The maximum key is:  %d\n", tree.max(tree.getRoot())));


        if (false) {
            System.out.println("Inorder traversal of the given tree");
            tree.inOrderPrint();

            System.out.println("\nDelete 20");
            tree.deleteItem(20);
            System.out.println("Inorder traversal of the modified tree");
            tree.inOrderPrint();

            System.out.println("\nDelete 30");
            tree.deleteItem(30);
            System.out.println("Inorder traversal of the modified tree");
            tree.inOrderPrint();

            System.out.println("\nDelete 50");
            tree.deleteItem(50);
            System.out.println("Inorder traversal of the modified tree");
            tree.inOrderPrint();
        }
    }
}
