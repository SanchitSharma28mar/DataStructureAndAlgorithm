package com.leetcode.string;

/**
 * LeetCode: 1768 (E)
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 * ---
 *  Input: word1 = "abc", word2 = "pqr"
 *  Output: "apbqcr"
 */
public class MergeStrings {

    private static String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int s1 = 0;
        int s2 = 0;
        while((s1 != word1.length()) &&
                s2 != word2.length()){
            merged.append(word1.charAt(s1));
            merged.append(word2.charAt(s2));
            s1++;
            s2++;
        }

        while(s1 != word1.length()) {
            merged.append(word1.charAt(s1));
            s1++;
        }
        while(s2 != word2.length()){
            merged.append(word2.charAt(s2));
            s2++;
        }
        return merged.toString();
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));
    }
}
