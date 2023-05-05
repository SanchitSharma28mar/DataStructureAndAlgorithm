package com.algorithm.slidingwindow;

/**
 * 
 * Fixed Size Sliding Window Variant.
 * 
 * Given an array of positive integers, and a positive number k, find the index range of minimum sum of any contiguous subarray of size k
 * Input: {10, 4, 2, 5, 6, 3, 8, ,}, k = 3
 * Output: Subarray of size 3 with minimum sum ranges from (1,3)
 * 
 * @author sanchitsharma
 *
 */
public class E5_Subarray_OfLength_K_Having_MinSum {
	
	public static void main(String[] args) {
		int[] arr = new int[] {10, 4, 2, 5, 6, 3, 8, 1};
		int k = 3;
		subarrayRangeWithMinSum(arr, k);
	}

	private static void subarrayRangeWithMinSum(int[] arr, int k) {
		int finalEndIndex = 0;
		int currentMinSum = 0;
		int minSum = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++) {
			currentMinSum += arr[i];
			if(i >= (k - 1)) {
				if(currentMinSum < minSum) {
					minSum = currentMinSum;
					finalEndIndex = i; // Keep track of the index
				}
				currentMinSum -= arr[i - (k - 1)];
			}
		}
		System.out.println("Minimum Sum Subarray index range is (" + (finalEndIndex - k + 1) + "," + finalEndIndex + ")");
	}

}
