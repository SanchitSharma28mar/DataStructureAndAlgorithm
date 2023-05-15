package com.leetcode.array.blind;

/**
 * LeetCode: 153 (M)
 */
public class Search_Min_Rotated_Array {

    private static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            if(nums[left] <= nums[right]){
                return nums[left];
            }

            int mid = (left + right)/2;
            if(nums[mid] >= nums[left]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));
    }
}
