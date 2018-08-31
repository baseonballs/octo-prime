package io.octoprime.algo.ds.tree;

/**
 * Problem
 * Invert a binary tree.
 * Example
 * 1 1
 * / \ / \
 * 2 3 => 3 2
 * / \
 * 4 4
 * Challenge
 * Do it in recursion is acceptable, can you do it without recursion?
 */
public class InvertedBinaryTree {

    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
}
