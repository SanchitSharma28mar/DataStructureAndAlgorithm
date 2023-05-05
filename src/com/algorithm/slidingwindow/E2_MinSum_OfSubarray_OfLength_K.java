package com.algorithm.slidingwindow;

/**
 * 
 * Fixed Size Sliding Window Variant.
 * 
 * Given an array of positive integers, and a positive number k, find the minimum sum of any contiguous subarray of size k
 * Input: {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4
 * Output: 17
 * 
 * @author sanchitsharma
 *
 */
public class E2_MinSum_OfSubarray_OfLength_K {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 4, 2, 10, 23, 3, 1, 0, 20};
		int k = 4;
		int minSumSubarray = findMinSumSubarray(arr, k);
		System.out.println("Minimum Sum Subarray = " + minSumSubarray);
	}

	private static int findMinSumSubarray(int[] arr, int k) {
		int currentMaxSum = 0;
		int minSum = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++) {
			currentMaxSum += arr[i];
			if(i >= (k - 1)) {
				minSum = Math.min(minSum, currentMaxSum);
				currentMaxSum -= arr[i - (k - 1)];
			}
		}
		return minSum;
	}

}
