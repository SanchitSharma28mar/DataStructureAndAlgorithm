package com.leetcode.stack;

import java.util.Stack;

/**
 * LeetCode: 84 (H)
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 * ---
 *  Input: heights = [2,1,5,6,2,3]
 *  Output: 10
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    private static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        while(index < heights.length) {
            int currentHeight = heights[index];
            // Push only when stack is empty or current height is >= top element on stack
            if(stack.isEmpty()
                    || currentHeight >= heights[stack.peek()]) {
                stack.push(index);
                index++;
            } else {
                int poppedIndex = stack.pop();
                int heightOfPopped = heights[poppedIndex];
                int width = stack.isEmpty() ? index : index - stack.peek() - 1;
                maxArea = Math.max(maxArea, heightOfPopped * width);
            }
        }

        while(!stack.isEmpty()) {
            int poppedIndex = stack.pop();
            int heightOfPopped = heights[poppedIndex];
            int width = stack.isEmpty() ? index : index - stack.peek() - 1;
            maxArea = Math.max(maxArea, heightOfPopped * width);
        }
        return maxArea;
    }
}
