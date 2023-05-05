package com.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode: 128
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * ---
 *  Input: nums = [100,4,200,1,3,2]
 *  Output: 4
 */
public class Longest_Consecutive_Sequence {

    private static int longestConsecutive(int[] nums) {
        int maxLength = 0;

        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        for(int num : nums) {
            if(!set.contains(num - 1)) {
                // num is the start of any sequence
                int currentLength = 1;
                while(set.contains(num + 1)){
                    currentLength++;
                    num++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
