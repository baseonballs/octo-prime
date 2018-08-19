package io.octoprime.algo.ds.tree.codec;

import io.octoprime.algo.ds.tree.TreeNode;

/**
 * Serialize and Deserialize BST(#4 flag).java
 */
public class Codec4 {


    private void buildString(TreeNode root, StringBuilder sb) {

        if (root == null) return;
        char flag = (char) 0;  // 00 01 10 11
        if (root.left != null) flag |= (char) 1;
        if (root.right != null) flag |= (char) 2;
        sb.append(flag);
        for (int i = 0, val = root.key; i < 4; i++, val >>>= 8) {
            sb.append((char) (val & 0xff));
        }
        buildString(root.left, sb);
        buildString(root.right, sb);
    }


    private TreeNode parseString(String data, int[] pos) {
        if (pos[0] >= data.length()) return null;

        char flag = data.charAt(pos[0]++);
        int val = 0;
        for (int i = 0; i < 4; i++) {
            val |= (data.charAt(pos[0]++) << (i * 8));
        }

        TreeNode root = new TreeNode(val);
        if ((flag & 1) != 0) {
            root.left = parseString(data, pos);
        }
        if ((flag & 2) != 0) {
            root.right = parseString(data, pos);
        }
        return root;

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder strb = new StringBuilder();
        buildString(root, strb);
        return strb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] pos = {0};
        return parseString(data, pos);
    }

    /**
     * @param args
     */
    public void main(String[] args) {
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
    }
}
