package com.leetcode.array.blind;

/**
 * LeetCode: 268 (E)
 */
public class Missing_Number {

    private static int missingNumber(int[] nums) {
        int length = nums.length;
        int expectedSum = length * (length + 1)/2;
        int actualSum = 0;
        for(int element : nums)
            actualSum += element;
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));
    }
}
