package com.leetcode.array;

/**
 * LeetCode: 35 (E)
 *  Given a sorted array of distinct integers and a target value, return the index if the target is found.
 *  If not, return the index where it would be if it were inserted in order.
 *  ---
 *  Input: nums = [1,3,5,6], target = 7
 *  Output: 4
 */
public class Search_Insert_Position_In_Sorted_Array {

    /*
     * Use Binary Search to find the index
     */
    public static int searchInsert(int[] nums, int target) {
        if(null == nums || nums.length == 0)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        return searchInsertHelper(nums, target, left, right);
    }

    private static int searchInsertHelper(int[] nums, int target, int left, int right) {
        int mid = (right + left)/2;
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] > target){
            return left < mid ? searchInsertHelper(nums, target, left, mid - 1) : left;
        } else {
            return right > mid ? searchInsertHelper(nums, target, mid + 1, right) : right + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,6,7};
        int target = 3;
        System.out.println(searchInsert(nums, target));
    }
}
