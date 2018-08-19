package io.octoprime.algo.ds.tree;

/**
 * Node object used by  singly linked list;
 */
public class TreeNode {

    int key;
    TreeNode left;
    TreeNode right;

    /**
     * constructor for the TreeNode
     *
     * @param key the ndoe's value
     */
    TreeNode(int key) {
        this.key = key;
        left = right = null;
    }
}
