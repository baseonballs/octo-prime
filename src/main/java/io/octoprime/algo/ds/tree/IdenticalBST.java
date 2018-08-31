package io.octoprime.algo.ds.tree;

public class IdenticalBST {

    /**
     * @param a, b, the root of binary trees.
     * @return true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else {
            return a.key == b.key && isIdentical(a.left, b.left)
                    && isIdentical(a.right, b.right);
        }
    }
}
