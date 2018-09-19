package io.octoprime.algo.ds.tree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrieTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void search() {

        Trie trie = new Trie();

        trie.insert("their");

        System.out.println(trie.delete("their"));                    // true

        trie.insert("there");
        trie.insert("this");
        trie.insert("that");
        trie.insert("does");
        trie.insert("did");
        trie.insert("the");
        System.out.println(trie.search("there"));                    // true
        System.out.println(trie.search("therein"));                    // false
        System.out.println(trie.startsWith("th"));                    // true
        System.out.println(trie.startsWith("fab"));                    // false
        System.out.println(trie.delete("does"));                    // true
        System.out.println(trie.startsWith("does"));                    // false
        System.out.println(trie.startsWith("o"));                    // false

        System.out.println(trie.search("the"));                        // true
        System.out.println(trie.startsWith("the"));                    // true
    }

    @Test
    void startsWith() {
    }
}