package io.octoprime.algo.ds.tree;

import java.util.*;

/**
 * A binary search tree (BST) is a node based binary tree data structure which has the following properties.
 * • The left subtree of a node contains only nodes with keys less than the node’s key.
 * • The right subtree of a node contains only nodes with keys greater than the node’s key.
 * • Both the left and right subtrees must also be binary search trees.
 * <p>
 * From the above properties it naturally follows that:
 * • Each node (item in the tree) has a distinct key.
 */
public class BinarySearchTree {

    static boolean TEST_MIN_MAX = false;
    static boolean TEST_TRAVERSAL = true;
    static boolean TEST_DELETE = false;
    static boolean TEST_ISVALID = false;
    static boolean TEST_SEARCH = false;
    static boolean TEST_SERDESER = true;

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
     * We can use QueueArray based level order traversal to optimize the time complexity of this method.
     * The QueueArray based level order traversal will take O(n) time in worst case. Thanks to Nitish, DivyaC and
     * tech.login.id2 for suggesting this optimization. See their comments for implementation using queue-based
     * traversal.
     * <p>
     * Method 2 (Using Level Order Traversal with QueueArray)
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

    Node find(Node node, int key) {
        if (node == null) return null;

        if (key < node.key)
            return find(node.left, key);
        else if (key > node.key)
            return find(node.right, key);

        return node;
    }

    /**
     * @return
     */
    public boolean isValid() {
        return isWithinMinMaxConstraint(_root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    /**
     * Returns true if the given tree is a BST and its values are >= min and <= max.
     */
    boolean isWithinMinMaxConstraint(Node node, int min, int max) {
        /* an empty tree is BST */
        if (node == null)
            return true;

        return node.key > min && node.key < max && isWithinMinMaxConstraint(node.left, min, node.key) &&
                isWithinMinMaxConstraint(node.right, node.key, max);

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

    /**
     * Level order is essentally a BFS tranversal. We look at all the immediate children first before processsing the sub-children.
     *
     * @param n
     */
    void levelOrderTraversal(Node n) {
        if (n == null) return;

        Queue<Node> q = new LinkedList<Node>();
        q.add(n);

        while (!q.isEmpty()) {
            Node elem = q.poll();

            System.out.print(elem.key + " ");

            if (elem.left != null)
                q.add(elem.left);
            if (elem.right != null)
                q.add(elem.right);
        }

    }

    /**
     * inorder-travasal uses a DFS which employs a stack.
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.key);
            root = root.right;

        }
        return list;
    }

    /**
     * find the kth smallest element in BST.
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) break;
            root = root.right;
        }
        return root.key;
    }

    public boolean isValidBST(Node node) {
        Stack<Node> stack = new Stack<>();
        Node t = null;

        if (node == null) return true;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (t != null && node.key <= t.key) return false;
            t = node;

            node = node.right;
        }
        return true;
    }


    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(Node root) {
        if (root == null) return "";

        Queue<Node> queue = new LinkedList<>();
        List<String> elems = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                elems.add("#");
            } else {
                elems.add(node.key + "");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        int size = elems.size();
        String result = "";
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                result += elems.get(i);
            } else {
                result += "," + elems.get(i);
            }
        }
        return result;

    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] parts = data.split(",");
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(parts[0]));
        queue.offer(root);
        int i = 1;
        while (i < parts.length) {
            Node node = queue.poll();

            if (parts[i].equals("#")) {
                node.left = null;
            } else {
                Node left = new Node(Integer.parseInt(parts[i]));
                node.left = left;
                queue.offer(left);
            }

            if (i + 1 == parts.length) break;

            if (parts[i + 1].equals("#")) {
                node.right = null;
            } else {
                Node right = new Node(Integer.parseInt(parts[i + 1]));
                node.right = right;
                queue.offer(right);
            }
            i += 2;
        }
        return root;
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

        if (TEST_ISVALID) {
            boolean isValid = tree.isValid();
            System.out.println(String.format("Tree is valid: %s", isValid ? "Yes" : "No"));
        }

        if (TEST_SEARCH) {
            Node n = tree.find(tree.getRoot(), 20);
            if (n == null) System.out.println("Node not found for key = " + 20);
            else System.out.println("Node  found for key = " + 20);
        }


        if (TEST_TRAVERSAL && false) {

            /**
             * level order traversal : serialize to std output
             */
            tree.levelOrderTraversal(tree.getRoot());
            System.out.println(String.format("\n\nThe minimum key is:  %d", tree.min(tree.getRoot())));


            /**
             * in order traversal : serialize to std output
             */

            System.out.println("Inorder traversal of the given tree");
            tree.inOrderPrint();

            /**
             * pre order traversal : serialize to std output
             */
            System.out.println("\nPreorder traversal of the given tree");
            tree.preOrderPrint();

            /**
             * post order traversal : serialize to std output
             */
            System.out.println("\nPostorder traversal of the given tree");
            tree.postOrder();
            System.out.println(String.format("\n\nThe minimum key is:  %d", tree.min(tree.getRoot())));
        }

        if (TEST_SERDESER) {
            tree.preOrderPrint(tree.getRoot());

            String ser = tree.serialize(tree.getRoot());
            System.out.println("\nSerialized tree: " + ser);

            Node n = tree.deserialize(ser);

            tree.preOrderPrint(n);
        }

        if (TEST_MIN_MAX) {
            System.out.println(String.format("The maximum key is:  %d\n", tree.max(tree.getRoot())));

            tree.deleteItem(20);
            System.out.println("Inorder traversal of the given tree");
            tree.inOrderPrint();
            System.out.println(String.format("\n\nThe minimum key is:  %d", tree.min(tree.getRoot())));
            System.out.println(String.format("The maximum key is:  %d\n", tree.max(tree.getRoot())));
        }

        if (TEST_DELETE) {
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
