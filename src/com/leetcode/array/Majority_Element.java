package com.leetcode.array;

import java.util.Arrays;

/**
 * LeetCode: 169 (E)
 *  Given an array nums of size n, return the majority element. The majority element is the element that appears
 *  more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
public class Majority_Element {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    private static int majorityElement(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        Arrays.sort(nums);
        return nums[(nums.length - 1)/2];
    }
}
