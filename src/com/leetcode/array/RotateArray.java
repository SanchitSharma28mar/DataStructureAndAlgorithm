package com.leetcode.array;

/**
 * LeetCode: 189
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * ---
 *  Input: nums = [1,2,3,4,5,6,7], k = 3
 *  Output: [5,6,7,1,2,3,4]
 */
public class RotateArray {

    /*
     * Step 1: Reverse the first part of array till k ==> O(k)
     * Step 2: Reverse the second part of array after k ==> O(n - k)
     * Step 3: Reverse the complete array ==> O(n)
     */
    public static void rotate(int[] nums, int k) {
//        print(nums);
        int length = nums.length;
//        k = k % length;
        // Step 1 : reverse the first part of array
        int left = 0;
        int right = length - 1 - k;
        for(int i = left; i < right; i++){
            int t = nums[i];
            nums[i] = nums[right];
            nums[right] = t;
            right--;
        }
        // Step 2: reverse the second part of array
        left = length - k;
        right = length - 1;
        for(int i = left; i < right; i++){
            int t = nums[i];
            nums[i] = nums[right];
            nums[right] = t;
            right--;
        }
        // Step 3: reverse the complete array
        for(int i = 0; i < length/2; i++){
            int t = nums[i];
            nums[i] = nums[length - 1 - i];
            nums[length - 1 - i] = t;
        }
//        print(nums);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        rotate(nums, k);
    }

//    private static void print(int[] nums) {
//        for(int i : nums) System.out.print(i + " ");
//        System.out.println();
//    }
}
