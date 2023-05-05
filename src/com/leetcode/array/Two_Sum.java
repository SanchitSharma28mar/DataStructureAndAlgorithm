package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: 1 (E)
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * ---
 *  Input: nums = [2,7,11,15], target = 9
 *  Output: [0,1]
 *  Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * ---
 *  Input: nums = [3,2,4], target = 6
 *  Output: [1,2]
 */

public class Two_Sum {

    /*
     * Use Map to put the number and for each number check if the difference is present in the map
     */
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            // Check the diff as key.
            if(map.containsKey(diff)){
                return new int[]{map.get(diff) , i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {11,15, 7, 2}; // [3,2,3], 6 --- [0,2]
        int targetSum = 9;
        int[] indexes = twoSum(nums, targetSum);
        System.out.println(indexes[0] + " and " + indexes[1]);
    }
}
