package com.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode: 22 (M)
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParenthesis {
    private static Stack<String> stack = new Stack<>();
    private static List<String> result = new ArrayList<>();

    private static List<String> generateParenthesis(int n) {
        int openCount = 0;
        int closeCount = 0;
        backTrack(openCount, closeCount, n);
        return result;
    }


    private static void backTrack(int openCount, int closeCount, int n) {
        /*
            General Rules:
            1. Only add open when open < n
            2. Only add close when close < open
            3. Validate base case if open == close == n
         */
        if(openCount == closeCount && closeCount == n){
            // Take all elements of stack and create the final string
            result.add(String.join("", stack));
        }

        if(openCount < n){
            stack.push("(");
            backTrack(openCount + 1, closeCount, n);
            stack.pop();
        }

        if(closeCount < openCount){
            stack.push(")");
            backTrack(openCount, closeCount + 1, n);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
