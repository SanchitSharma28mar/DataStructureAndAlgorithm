package com.leetcode.trie;

import lombok.Data;

/**
 * LeetCode: 238 (M)
 *
 */
public class Trie {

    private TrieNode root;

    public Trie(){
        root = new TrieNode('0');
    }

    public void insert(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            if(current.getChildren()[ch - 'a'] == null){
                current.getChildren()[ch - 'a'] = new TrieNode(ch);
            }
            current = current.getChildren()[ch - 'a'];
        }
        current.setEndOfWord(true);
    }

    public boolean search(String word) {
        TrieNode result = getLastNode(word);
        return result!= null && result.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode result = getLastNode(prefix);
        return result != null;
    }

    private TrieNode getLastNode(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            if(current.getChildren()[ch - 'a'] == null){
                return null;
            }
            current = current.getChildren()[ch - 'a'];
        }
        return current;
    }

}

