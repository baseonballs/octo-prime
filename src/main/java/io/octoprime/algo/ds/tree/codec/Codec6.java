package io.octoprime.algo.ds.tree.codec;

import io.octoprime.algo.ds.tree.TreeNode;

import java.util.LinkedList;

/**
 *
 */
public class Codec6 {


    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serial = serialize(root);
        // System.out.println(serial);
        TreeNode res = deserialize(serial);
        // if (res == null) System.out.println("null");
        // else System.out.println(res.val);
    }

    /**
     * @param root
     * @return
     */
    public static String serialize(TreeNode root) {
        LinkedList<TreeNode> s = new LinkedList<TreeNode>();
        if (root != null) s.offer(root);
        else s.offer(new TreeNode(Integer.MIN_VALUE));
        String res = "";
        while (!s.isEmpty()) {
            TreeNode cur = s.poll();
            // System.out.println(cur.val + ", ");
            if (cur.key == Integer.MIN_VALUE) res += "null,";
            else {
                res += String.valueOf(cur.key) + ",";
                if (cur.left == null) s.offer(new TreeNode(Integer.MIN_VALUE));
                else s.offer(cur.left);
                // System.out.println(cur.right.val);
                if (cur.right == null) s.offer(new TreeNode(Integer.MIN_VALUE));
                else s.offer(cur.right);
            }
        }
        return res;
    }

    /**
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) {
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        String[] ss = data.split(",");
        int i = 0;
        TreeNode cur = null, root = null;
        if (!ss[i].equals("null")) {
            // System.out.println(Integer.parseInt(ss[i]));
            root = new TreeNode(Integer.parseInt(ss[i]));
            cur = root;
            list.offer(cur);
        }
        while (!list.isEmpty()) {
            cur = list.poll();
            // System.out.print(cur.val + ": ");
            if (ss[++i].equals("null")) {
                cur.left = null;
                // System.out.print("null, ");
            } else {
                // System.out.print(Integer.parseInt(ss[i]) + ", ");
                cur.left = new TreeNode(Integer.parseInt(ss[i]));
                list.offer(cur.left);
            }
            if (ss[++i].equals("null")) {
                cur.right = null;
                // System.out.println("null, ");
            } else {
                // System.out.println(Integer.parseInt(ss[i]));
                cur.right = new TreeNode(Integer.parseInt(ss[i]));
                list.offer(cur.right);
            }
        }
        return root;
    }
}
