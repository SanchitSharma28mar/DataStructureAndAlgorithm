package com.leetcode.array.blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode: 15 (M)
 *  Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 *      such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *  Input: nums = [-1,0,1,2,-1,-4]
 *  Output: [[-1,-1,2],[-1,0,1]]
 */
public class Three_Sum {

    /*
     * Sort Array
     * Then Use 2 Pointer strategy to get the sum of i, left and right
     * Move the pointers accordingly
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums); // Time complexity - O(NLog)
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int currentSum = nums[i] + nums[left] + nums[right];
                if(currentSum > 0){
                    right--;
                } else if (currentSum < 0){
                    left++;
                } else if(currentSum == 0){
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    // Takes care of same value at left index
                    while(nums[left] == nums[left - 1] && left < right){
                        left++;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}
