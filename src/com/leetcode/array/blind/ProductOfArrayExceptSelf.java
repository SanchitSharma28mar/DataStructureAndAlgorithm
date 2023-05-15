package com.leetcode.array.blind;

import java.util.Arrays;

/**
 * LeetCode: 238 (M)
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * ---
 *  Input: nums = [1,2,3,4]
 *  Output: [24,12,8,6]
 */
public class ProductOfArrayExceptSelf {

    private static int[] productExceptSelf(int[] nums) {
        int[] productArray = new int[nums.length];

        int prefix = 1;
        for(int i = 0; i < nums.length; i++){
            productArray[i] = prefix;
            prefix *= nums[i];
        }

        int postFix = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            productArray[i] *= postFix;
            postFix *= nums[i];
        }

        return productArray;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] productExceptSelf = productExceptSelf(nums);
        System.out.println("ProductOfArrayExceptSelf = " + Arrays.toString(productExceptSelf));
    }
}
