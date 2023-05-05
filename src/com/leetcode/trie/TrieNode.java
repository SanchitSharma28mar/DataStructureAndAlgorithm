package com.leetcode.trie;

import lombok.Data;

@Data
class TrieNode {
    private char value;
    private boolean isEndOfWord;
    private TrieNode[] children;

    public TrieNode(char value) {
        this.value = value;
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
    }
}
