package io.octoprime.algo.ds.tree.codec;

import io.octoprime.algo.ds.tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * best solution
 */
public class Codec5 {

    public static String splitter = ",";
    public static String nl = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        return sb.toString();
    }

    public void buildString(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append(nl).append(splitter);
        } else {
            sb.append(root.key).append(splitter);
            buildString(sb, root.left);
            buildString(sb, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> l = Arrays.asList(data.split(splitter));
        Deque<String> d = new LinkedList(l);
        return buildTree(d);
    }

    public TreeNode buildTree(Deque<String> d) {
        String val = d.remove();
        if (val.equals(nl)) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = buildTree(d);
            root.right = buildTree(d);
            return root;
        }
    }

    public void main(String[] args) {
        // Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
    }
}