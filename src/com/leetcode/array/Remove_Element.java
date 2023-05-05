package com.leetcode.array;

/**
 * LeetCode: 27 (E)
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The relative order of the elements may be changed.
 * ---
 *  Input: nums = [0,1,2,2,3,0,4,2], val = 2
 *  Output: 5
 */
public class Remove_Element {

    /*
     * 2 Pointer Strategy
     */
    private static int removeElementInPlace(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            if(nums[right] == val) {
                right--;
            } else if(nums[left] == val) {
                swapLeftRight(nums, left, right);
                right--;
                left++;
            } else if(nums[left] != val) {
                left++;
            }
        }
        return right + 1;
    }

    private static void swapLeftRight(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int index = removeElementInPlace(nums, val);
        System.out.println(index);
        for (int i = 0; i < index; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
