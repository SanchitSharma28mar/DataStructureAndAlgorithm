package com.leetcode.array;

/**
 * LeetCode: 162 (M)
 *  A peak element is an element that is strictly greater than its neighbors.
 */
public class Find_Any_Peak_Element_Index {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }
    private static int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        int left = 1;
        int right = nums.length - 2;
        if(nums[0] > nums[1])
            return 0;

        if(nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;

        while(left <= right) {
            int mid = (left + right)/2;
            if(nums[mid] > nums[mid - 1]  &&  nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] < nums[mid - 1])
                right = mid - 1;
            else if (nums[mid] < nums[mid + 1])
                left = mid + 1;
        }

        return -1;
    }
}
