package com.leetcode.array;

import java.util.Arrays;

/**
 * LeetCode: 283 (E)
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * ---
 *  Input: nums = [0,1,0,3,12]
 *  Output: [1,3,12,0,0]
 */
public class Move_0s_To_End {

    /*
     * Create a growing snowball of Zeroes and then move non-zero element to start index of snowball
     */
    private static void moveZeroesToEnd(int[] nums) {
        int windowOfZeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                windowOfZeroes++;
            } else if(windowOfZeroes > 0){
                nums[i - windowOfZeroes] = nums[i];
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroesToEnd(nums);
        System.out.println("Array after moving zeroes to right = " + Arrays.toString(nums));
    }
}
