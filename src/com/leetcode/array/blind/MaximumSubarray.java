package com.leetcode.array.blind;

/**
 * LeetCode: 53 (M)
 * Given an integer array nums, find the  subarray with the largest sum, and return its sum.
 * ---
 *  Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 *  Output: 6
 *  Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 */
public class MaximumSubarray {

    private static int maxSubArray(int[] nums) {
        int MaxSum = Integer.MIN_VALUE;
        int currSum = 0;
        if(nums.length == 1) {
            return nums[0];
        }
        for (int num : nums) {
            currSum = currSum + num;
            MaxSum = Math.max(MaxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return MaxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
