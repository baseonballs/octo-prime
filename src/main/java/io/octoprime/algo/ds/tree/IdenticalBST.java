package io.octoprime.algo.ds.tree;

/**
 * Problem
 * Compare two strings A and B, determine whether A contains all of the characters
 * in B.
 * The characters in string A and B are all Upper Case letters.
 * Example
 * For A = "ABCD" , B = "ACD" , return true.
 * For A = "ABCD" , B = "AABC" , return false.
 * Note
 * The characters of B in A are not necessary continuous or ordered.
 */
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
