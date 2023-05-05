package com.leetcode.slidingwindow;

/**
 * LeetCode: 643 (E)
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
 * ---
 *  Input: nums = [1,12,-5,-6,50,3], k = 4
 *  Output: 12.75000
 */
public class MaximumAverageSubarray_1 {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
    private static double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currentRunningSum = 0;
        for(int i = 0; i < nums.length; i++){
            currentRunningSum += nums[i];
            if(i >= (k - 1)){
                maxSum = Math.max(maxSum, currentRunningSum);
                currentRunningSum -= nums[i - (k - 1)];
            }
        }
        return maxSum*1.0/k;
    }
}
