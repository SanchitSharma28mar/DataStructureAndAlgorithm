package com.leetcode.string;

import java.util.Objects;

/**
 * LeetCode: 58 (E)
 *  Given a string s consisting of words and spaces, return the length of the last word in the string.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }
    private static int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        int j = split.length - 1;

        while(j >= 0) {
            if(Objects.equals(split[j], " ")) {
                j--;
            } else {
                return split[j].length();
            }
        }

        return 0;
    }
}
