package com.leetcode.string;

/**
 * LeetCode: 520 (E)
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *   All letters in this word are capitals, like "USA".
 *   All letters in this word are not capitals, like "leetcode".
 *   Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
 * ---
 *  Input: word = "USA"
 *  Output: true
 * ---
 *  Input: word = "FlaG"
 *  Output: false
 */
public class DetectCapital {
    public static void main(String[] args) {
        String word = "USA";
        System.out.println(detectCapitalUse(word));
    }

    private static boolean detectCapitalUse(String word) {
        boolean legal = true;
        if(ifFirstCharLower(word)) {
            if(word.length() == 1) {
                legal = true;
            } else {
                if(!ifAllCharLower(word)) {
                    legal = false;
                }
            }
        }
        else {
            if(word.length() == 1) {
                legal = true;
            } else {
                char second = word.charAt(1);
                if(Character.isUpperCase(second)) {
                    if(!ifAllCharUpper(word)) {
                        legal = false;
                    }
                } else {
                    if(ifAnyMiddleUpper(word)) {
                        legal = false;
                    }
                }
            }
        }

        return legal;
    }

    private static boolean ifAnyMiddleUpper(String word) {
        String substring = word.substring(1);
        for(char ch : substring.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    private static boolean ifAllCharLower(String word) {
        for(char ch : word.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean ifAllCharUpper(String word) {
        for(char ch : word.toCharArray()) {
            if(Character.isLowerCase(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean ifFirstCharLower(String word) {
        char first = word.charAt(0);
        if(Character.isLowerCase(first)) {
            return true;
        }
        return false;
    }
}
