package io.octoprime.algo.ds.tree;

public class CountPairs {


    /**
     * returns true if a pair exists with given sum 'x'
     */

    boolean findPair(TreeNode root, TreeNode temp, int sum) {
        // base case
        if (root == null)
            return false;

        // pair exists
        if (root != temp && ((root.key + temp.key) == sum))
            return true;

        // find pair in left and right subtress
        return findPair(root.left, temp, sum) || findPair(root.right, temp, sum);

        // pair does not exists with given sum 'x'
    }

    /**
     * function to count pairs in a binary tree whose sum is equal to given value x
     */
    int countPairs(TreeNode root, TreeNode curr, int x) {
        int count = 0;

        // if tree is empty
        if (curr == null)
            return count;

        // check whether pair exists for current node 'curr'
        // in the binary tree that sum up to 'x'
        if (findPair(root, curr, x))
            count++;

        countPairs(root, curr.left, x);
        countPairs(root, curr.right, x);

        return count;
    }

}
