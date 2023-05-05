package com.leetcode.stack;

import java.util.Stack;

/**
 * LeetCode: 2390 (M)
 * Removing Stars From a String
 * ---
 *  Input: s = "leet**cod*e"
 *  Output: "lecoe"
 *  Explanation: Performing the removals from left to right:
 *      - The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
 *      - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
 *      - The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
 *      There are no more stars, so we return "lecoe".
 */
public class RemoveStars {

    private static String removeStars(String s) {
        Stack<String> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '*'){
                stack.pop();
            } else {
                stack.add(String.valueOf(ch));
            }
        }

        return String.join("", stack);
    }

    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }
}
