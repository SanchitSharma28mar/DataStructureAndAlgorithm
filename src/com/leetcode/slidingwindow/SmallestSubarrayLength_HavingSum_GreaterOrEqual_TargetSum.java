package com.leetcode.slidingwindow;

/**
 * LeetCode: 209 (M)
 * Dynamic Size Sliding WIndow Variant.
 * Find the length of smallest subarray where sum >= targetSum
 * ---
 * 	Input: {4,2,2,7,5,1,2,6}, targetSum = 14
 * 	Output: 3
 * 
 * @author sanchitsharma
 *
 */
public class SmallestSubarrayLength_HavingSum_GreaterOrEqual_TargetSum {
	public static void main(String[] args) {
		int[] arr = {4,2,2,7,5,1,2,6};
		int targetSum = 14;
		int minLength = findSmallestSubarrayLength(arr, targetSum);
		System.out.println(minLength);
		
	}

	private static int findSmallestSubarrayLength(int[] arr, int targetSum) {
		int minWindowSize = Integer.MAX_VALUE;
		int currentWindowSize = 0;
		int windowStart = 0;
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			currentWindowSize += arr[windowEnd];
			while(currentWindowSize >= targetSum) {
				minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
				currentWindowSize -= arr[windowStart++];
			}
		}
		return minWindowSize;
	}
}
