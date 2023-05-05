package com.algorithm.slidingwindow;

/**
 * Dynamic Size Sliding Window Variant
 * 
 * Find the smallest subarray having targetSum
 * 
 * Input: {2, 6, 0, 9, 7, 3, 1, 4, 1, 11}, targetSum = 15
 * Output: {6, 0, 9}
 * 
 * @author sanchitsharma
 *
 */
public class M1_AnySubarray_WithTargetSum {
	public static void main(String[] args) {
		int[] arr = {2, 6, 0, 9, 7, 3, 1, 4, 1, 11};
		int targetSum = 15;
		findSubarrayWithTargetSum(arr, targetSum);
	}

	private static void findSubarrayWithTargetSum(int[] arr, int targetSum) {
		int currentRunningSum = 0;
		int windowStart = 0;
		int windowEnd = 0;
		boolean sumFound = false;
		for(; windowEnd < arr.length; windowEnd++) {
			currentRunningSum += arr[windowEnd];
			if(currentRunningSum > targetSum) {
				while(currentRunningSum >= targetSum) {
					currentRunningSum -= arr[windowStart++];
					if(currentRunningSum == targetSum) {
						sumFound = true;
						break;
					}
				}
			}
			if(sumFound) {
				break;
			}
		}
		if(sumFound) {
			System.out.print("Subarray with the target sum is - ");
			for(int i = windowStart; i < windowEnd + 1; i++) {
				System.out.print(arr[i] + " ");
			}
		} else {
			System.out.println("Target sum not found");
		}
	}
}
