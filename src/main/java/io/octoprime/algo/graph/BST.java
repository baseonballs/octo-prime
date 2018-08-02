package io.octoprime.algo.graph;

public class BST {

    class Node
    {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    private Node _root;

    BST()
    {
        _root = null;
    }

    public Node getRoot() {return _root; }
    void deleteItem(int key)
    {
        _root = delete(_root, key);
    }

    Node delete(Node node, int key)
    {
        /* Base Case: If the tree is empty */
        if (node == null)  return node;

        /* Otherwise, recur down the tree */
        if (key < node.key)
            node.left = delete(node.left, key);
        else if (key > node.key)
            node.right = delete(node.right, key);

            // if key is same as _root's key, then This is the node
            // to be deleted
        else
        {
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

    int min(Node node)
    {
        if (node == null) return -1;

        int min = node.key;
        while (node.left != null)
        {
            min = node.left.key;
            node = node.left;
        }
        return min;
    }

    int max(Node node)
    {
        if ( node == null) return -1;

        int max = node.key;
        while ( node.right != null)
        {
            max = node.right.key;
            node = node.right;
        }

        return max;
    }

    void insert(int key)
    {
        _root = insertNode(_root, key);
    }

    Node insertNode(Node node, int key)
    {
        /* If the tree is empty, return a new node */
        if (node == null)
        {
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

    void inOrderPrint()
    {
        inorderPrint(_root);
    }

    void inorderPrint(Node node)
    {
        if (node != null)
        {
            inorderPrint(node.left);
            System.out.print(node.key + " ");
            inorderPrint(node.right);
        }
    }

    void postOrder()
    {
        postOrderPrint(_root);
    }
    void postOrderPrint(Node node)
    {
        if (node != null)
        {
            postOrderPrint(node.left);
            postOrderPrint(node.right);
            System.out.print(node.key + " ");
        }
    }

    void preOrderPrint()
    {
        preOrderPrint(_root);
    }

    void preOrderPrint(Node node)
    {
        if ( node != null)
        {
            System.out.print(node.key + " ");
            preOrderPrint(node.left);
            preOrderPrint(node.right);
        }
    }

    public static void main(String[] args)
    {
        BST tree = new BST();

        /* Let us create following BST
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
        System.out.println(String.format("\n\nThe minimum value is:  %d", tree.min(tree.getRoot())));
        System.out.println(String.format("The maximum value is:  %d\n", tree.max(tree.getRoot())));

        tree.deleteItem( 20 );
        System.out.println("Inorder traversal of the given tree");
        tree.inOrderPrint();
        System.out.println(String.format("\n\nThe minimum value is:  %d", tree.min(tree.getRoot())));
        System.out.println(String.format("The maximum value is:  %d\n", tree.max(tree.getRoot())));


        if ( false ) {
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
