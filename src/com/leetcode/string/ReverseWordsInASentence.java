package com.leetcode.string;

/**
 * LeetCode: 151 (M)
 * Given an input string s, reverse the order of the words.
 * ---
 *  Input: s = "the sky is blue"
 *  Output: "blue is sky the"
 */
public class ReverseWordsInASentence {
    public static void main(String[] args) {
        String s = "shanti villa";
        System.out.println(reverseWords(s));
    }
    private static String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i].isEmpty()) continue;
            sb.append(arr[i] + " ");
        }

        return sb.toString().trim();
    }
}
