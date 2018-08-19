package io.octoprime.algo.ds.tree.codec;

import io.octoprime.algo.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Serialize and Deserialize Binary Tree(#2 Preoder).java
 */
public class Codec2 {


    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('#').append(',');
        } else {
            sb.append(root.key).append(',');
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    private TreeNode parseString(List<String> nodes) {
        String temp = nodes.remove(0);
        if (temp.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(temp));
        root.left = parseString(nodes);
        root.right = parseString(nodes);
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
        List<String> nodes = new ArrayList<String>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return parseString(nodes);
    }

    // Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
