package com.leetcode.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * LeetCode: 150 (M)
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * ---
 *  Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 *  Output: 22
 *  Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 *   = ((10 * (6 / (12 * -11))) + 17) + 5
 *   = ((10 * (6 / -132)) + 17) + 5
 *   = ((10 * 0) + 17) + 5
 *   = (0 + 17) + 5
 *   = 17 + 5
 *   = 22
 */
public class EvaluateReversePolishNotation {
    private static final Set<String> operatorSet = new HashSet<>(Arrays.asList("+", "-", "/", "*"));

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens) {
            if(!operatorSet.contains(s)) {
                stack.push(Integer.valueOf(s));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int c = calculate(a, b, s);
                stack.push(c);
            }
        }
        return stack.pop();
    }
    private static int calculate(int a, int b, String s) {
        int c = 0;
        if(s.equalsIgnoreCase("+")) c = a + b;
        else if(s.equalsIgnoreCase("-")) c = a - b;
        else if(s.equalsIgnoreCase("*")) c = a * b;
        else if(s.equalsIgnoreCase("/")) c = a / b;
        return c;
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
