package io.octoprime.algo.ds.tree;

import java.util.HashMap;

class Trie {

    // root node
    private TrieNode root;

    // default case
    Trie() {
        root = new TrieNode();
        root.setParent(new TrieNode());
    }

    // inserting a word
    void insert(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();

        // parent node
        TrieNode p = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode t;

            if (children.containsKey(c)) {

                // character already found in children
                t = children.get(c);

            } else {

                // adding new character to children
                t = new TrieNode(c);
                children.put(c, t);
                t.setParent(p);
            }

            p = t;
            children = t.getChildren();

            // last character from word
            if (i == word.length() - 1) {
                t.setLeaf(true);
            }
        }
    }

    boolean delete(String word) {
        TrieNode t = searchNode(word);

        // word is present if t is not null & is leaf as t is a trie node for last character from word
        if (t != null && t.isLeaf()) {

            TrieNode p = t.getParent();
            char c = t.getCharacter();

            // removing children of parent if only one child is present
            while (p.getChildren().size() == 1) {
                p.resetChildren();
                t = p;
                c = t.getCharacter();
                p = t.getParent();
            }

            // removing the remaining character
            char delete = c;
            p.getChildren().entrySet().removeIf(e -> e.getKey().equals(delete));

            return true;
        }
        return false;
    }

    boolean search(String word) {
        TrieNode t = searchNode(word);

        // word is present if t is not null & is leaf as t is a trie node for last character from word
        return t != null && t.isLeaf();

    }

    boolean startsWith(String prefix) {
        HashMap<Character, TrieNode> children = root.getChildren();

        TrieNode t;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (children.containsKey(c)) {

                t = children.get(c);
                children = t.getChildren();

            } else {
                // character mismatch
                return false;
            }
        }

        // reached the end of the prefix word
        return true;
    }

    // helper method for searching & delete functions
    private TrieNode searchNode(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();

        TrieNode t = null;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (children.containsKey(c)) {

                t = children.get(c);
                children = t.getChildren();

            } else {
                // character mismatch
                return null;
            }
        }

        // reached the end of the search word
        return t;
    }
}

class TrieNode {

    private char character;
    private TrieNode parent;
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private boolean leaf;

    // default case
    TrieNode() {
    }

    // constructor accepting the character
    TrieNode(char character) {
        this.character = character;
    }

    void setCharacter(char character) {
        this.character = character;
    }

    char getCharacter() {
        return character;
    }

    void setParent(TrieNode parent) {
        this.parent = parent;
    }

    TrieNode getParent() {
        return parent;
    }

    HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    void resetChildren() {
        children = new HashMap<>();
    }

    boolean isLeaf() {
        return leaf;
    }

    void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
}

