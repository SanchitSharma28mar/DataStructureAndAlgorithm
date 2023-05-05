package com.leetcode.string;

import java.util.*;

/**
 * LeetCode: 316 (M)
 * Given a string s, remove duplicate characters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * ---
 *  Input: s = "bcabc"
 *  Output: "abc"
 * ---
 *  Input: s = "cbacdcbc"
 *  Output: "acdb"
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        String s = "cbacdcbc"; //
        System.out.println(removeDuplicateCharacters(s));
    }

    public static String removeDuplicateCharacters(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            freq[ch - 'a']--;
            if(visited[ch - 'a'])
                continue;

            while(!stack.isEmpty()
                    &&  ch < stack.peek()
                    && freq[stack.peek() - 'a'] != 0){

                visited[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
