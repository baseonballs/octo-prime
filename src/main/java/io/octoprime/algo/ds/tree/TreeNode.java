package io.octoprime.algo.ds.tree;

/**
 * Node object used by  singly linked list;
 */
public class TreeNode {

    public int key;
    public TreeNode left;
    public TreeNode right;

    /**
     * constructor for the TreeNode
     *
     * @param key the ndoe's value
     */
    public TreeNode(int key) {
        this.key = key;
        left = right = null;
    }
}
