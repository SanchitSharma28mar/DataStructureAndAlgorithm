package com.algorithm.slidingwindow;

/**
 * 
 * Fixed Size Sliding Window Variant.
 * 
 * Given an array of positive integers, and a positive number k, find the maximum sum of any contiguous subarray of size k
 * Input: {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4
 * Output: 39
 * 
 * @author sanchitsharma
 *
 */
public class E1_MaxSum_OfSubarray_OfLength_K {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 4, 2, 10, 23, 3, 1, 0, 20};
		int k = 4;
		int maxSumSubarray = findMaxSumOfSubarray(arr, k);
		System.out.println("Maximum Sum Subarray = " + maxSumSubarray);
	}

	private static int findMaxSumOfSubarray(int[] arr, int k) {
		int currentMaxSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			currentMaxSum += arr[i];
			if(i >= (k - 1)) {
				maxSum = Math.max(maxSum, currentMaxSum);
				currentMaxSum -= arr[i - (k - 1)];
			}
		}
		return maxSum;
	}

}
