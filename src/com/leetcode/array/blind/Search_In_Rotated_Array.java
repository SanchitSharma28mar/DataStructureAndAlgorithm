package com.leetcode.array.blind;

/**
 * LeetCode: 33 (M)
 * ---
 *  Input: nums = [4,5,6,7,0,1,2], target = 0
 *  Output: 4
 */
public class Search_In_Rotated_Array {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target)
                return mid;
            // Condition for mid falling on left sorted portion of the array
            if(nums[mid] >= nums[left]){
                // search the right portion
                if( target > nums[mid]){
                    left = mid + 1;
                }
                // search the right portion
                else if(target < nums[mid] && target < nums[left]) {
                    left = mid + 1;
                }
                // target is less than nums[mid] but greater than nums[left],
                // search the left portion
                else {
                    right = mid - 1;
                }
            }
            // Condition for mid falling on right sorted portion of the array
            else {
                // If target is smaller than nums[mid], search left portion
                if(target < nums[mid]){
                    right = mid - 1;
                }
                // search left portion
                else if(target > nums[mid] && target > nums[right]){
                    right = mid - 1;
                }
                // Search right portion
                else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
