package com.leetcode.string;

import java.util.Stack;

/**
 * LeetCode: 1081 (M)
 * Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.
 * ---
 *  Input: s = "bcabc"
 *  Output: "abc"
 */
public class SmallestSubsquenceOfDistinctChars {
    private static String smallestSubsequence(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) freq[c - 'a']++;

        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            freq[c - 'a']--;
            if(visited[c - 'a']) continue;

            while(!stack.isEmpty() && c < stack.peek() && freq[stack.peek() - 'a'] != 0){
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;

        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(smallestSubsequence(s));
    }
}
