package io.octoprime.algo.ds.tree;


public class ZSandbox {

    public TreeNode lca(TreeNode t, TreeNode a, TreeNode b) {
        if (t == null || (t == a) || t == b) {
            return t;
        }

        TreeNode l = lca(t.left, a, b);
        TreeNode r = lca(t.right, a, b);

        if (l != null && r != null) return t;

        return l == null ? r : l;
    }

    public static void main(String[] args) {

    }
}
