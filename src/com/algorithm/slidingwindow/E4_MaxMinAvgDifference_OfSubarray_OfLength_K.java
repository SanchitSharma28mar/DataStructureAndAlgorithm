package com.algorithm.slidingwindow;

/**
 * Fixed Size Sliding Window Variant
 * 
 * Difference between maximum and minimum average of all k-length contiguous subarray
 * 
 * @author sanchitsharma
 *
 */
public class E4_MaxMinAvgDifference_OfSubarray_OfLength_K {
	public static void main(String[] args) {
		int[] arr = {3,8,9,15};
		int k = 2;
		double maxMinDiff = findMaxMinDiff(arr, k);
		System.out.println(maxMinDiff);
	}

	private static double findMaxMinDiff(int[] arr, int k) {
		int currentMaxSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int minSum = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++) {
			currentMaxSum += arr[i];
			if(i >= (k - 1)) {
				maxSum = Math.max(maxSum, currentMaxSum);
				minSum = Math.min(minSum, currentMaxSum);
				currentMaxSum -= arr[i - (k - 1)];
			}
		}
		double maxAvg = maxSum * 1.0/k;
		double minAvg = minSum * 1.0/k;
		return maxAvg - minAvg;
	}
}
