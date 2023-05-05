package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: 217 (E)
 *  Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
public class Contains_Duplicates_1 {
    private static boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                return true;
            } else {
                map.put(i, true);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums));
    }
}
