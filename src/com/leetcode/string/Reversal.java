package com.leetcode.string;

/**
 * LeetCode: 344 (E)
 * Write a function that reverses a string.
 * ---
 *  Input: s = ["h","e","l","l","o"]
 *  Output: ["o","l","l","e","h"]
 */
public class Reversal {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }

    private static void reverseString(char[] s) {
        System.out.println(s);
        for(int i = 0; i < s.length/2; i++){
            char t = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = t;
        }
        System.out.println(s);
    }
}
