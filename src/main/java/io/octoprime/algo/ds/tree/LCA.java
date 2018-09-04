package io.octoprime.algo.ds.tree;

/**
 * Problem
 * Given the root and two nodes in a Binary Tree. Find the lowest common
 * ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor
 * of both nodes.
 * Example
 * For the following binary tree:
 * 4
 * / \
 * 3 7
 * / \
 * 5 6
 * LCA(3, 5) = 4
 * LCA(5, 6) = 7
 * LCA(6, 7) = 7
 */
public class LCA {

    public TreeNode lca(TreeNode root, TreeNode
            A, TreeNode B) {

        if ((root == null) || (root == A || root == B)) {
            return root;
        }
        TreeNode left = lca(root.left, A, B);
        TreeNode right = lca(root.right, A, B);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
