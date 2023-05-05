package com.leetcode.stack;

import java.util.Stack;

/**
 * LeetCode: 155 (M)
 *
 */
public class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int val) {
        mainStack.push(val);
        int minValue = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(minValue);
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
