package io.octoprime.algo.ds.tree;

public class CountPairs {


    /**
     * returns true if a pair exists with given sum 'x'
     */

    boolean findPair(TreeNode root, TreeNode node, int sum) {
        // base case
        if (root == null)
            return false;

        // pair exists
        if (root != node && ((root.key + node.key) == sum))
            return true;

        // find pair in left and right subtress
        return findPair(root.left, node, sum) || findPair(root.right, node, sum);
    }

    /**
     * function to count pairs in a binary tree whose sum is equal to given value x
     */
    int countPairs(TreeNode root, TreeNode curr, int value) {
        int count = 0;

        // if tree is empty
        if (curr == null)
            return count;

        // check whether pair exists for current node 'curr'
        // in the binary tree that sum up to 'x'
        if (findPair(root, curr, value))
            count++;

        countPairs(root, curr.left, value);
        countPairs(root, curr.right, value);

        return count;
    }

}
