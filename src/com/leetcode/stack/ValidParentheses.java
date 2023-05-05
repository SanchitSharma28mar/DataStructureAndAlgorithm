package com.leetcode.stack;

import java.util.*;

/**
 * LeetCode: 20 (E)
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * ---
 *  Input: s = "()[]{}"
 *  Output: true
 */
public class ValidParentheses {
    private static final Set<Character> opening = new HashSet<>(Arrays.asList('(', '[', '{'));
    private static final Map<Character, Character> map = new HashMap<>() {{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};

    public static void main(String[] args) {
        String s = "())";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(opening.contains(ch)){
                stack.push(ch);
            } else if(!opening.contains(ch)){
                if(!stack.isEmpty() && map.get(ch) == stack.peek()){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
