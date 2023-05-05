package com.leetcode.array;

/**
 * LeetCode: 11 (M)
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * ---
 *  Input: height = [1,8,6,2,5,4,8,3,7]
 *  Output: 49
 */
public class Container_With_Most_Water {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
    private  static int maxArea(int[] height) {
        int maxArea= 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int currentArea = h * w;
            maxArea = Math.max(maxArea, currentArea);
            if(height[left] <= height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
