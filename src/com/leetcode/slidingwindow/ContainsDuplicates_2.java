package com.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode: 219 (E)
 * Given an integer array nums and an integer k, return true if there are two
 * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * ---
 *  Input: nums = [1,2,3,1,2,3], k = 2
 *  Output: false
 */
public class ContainsDuplicates_2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums, 2));
    }
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            // Sliding window
            if(i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
