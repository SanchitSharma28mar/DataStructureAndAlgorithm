package com.algorithm.slidingwindow;

/**
 * Dynamic Size Sliding Window Variant.
 * 
 * Find the maximum sequence of continuous 1's that can be formed by replacing at most k zeroes by ones
 * 
 * Input: { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0 }
 * Output:-
 * 	For k = 0, the length of the longest sequence is 4 (from index 6 to 9)
 * 	For k = 1, the length of the longest sequence is 7 (from index 3 to 9)
 * 	For k = 2, the length of the longest sequence is 10 (from index 0 to 9)
 * 	For k = 3, the length of the longest sequence is 11 (from index 0 to 10)
 * 
 * @author sanchitsharma
 *
 */
public class M7_MaxLength_OfOnes_AfterReplacing_K_Zero {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0 };
		int k = 2;
		int longestLength = findLongestLength(arr, k);
		System.out.println("Longest sequence length for k = " + k + " is " + longestLength);
	}

	private static int findLongestLength(int[] arr, int k) {
		// Maintain current count of 0's
		int currentCountOfZeroes = 0;
		int maxLength = Integer.MIN_VALUE;
		int windowStart = 0;
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			if(arr[windowEnd] == 0) {
				currentCountOfZeroes++;
			}
			if(currentCountOfZeroes > k) {
				// Find maxLength ands shrink the window rill 0
				maxLength = Math.max(maxLength, windowEnd - windowStart);
				while(arr[windowStart] != 0) {
					windowStart++;
				}
				// Pointer goes to next index of 0
				windowStart++;
				currentCountOfZeroes--;
			}
		}
		return maxLength;
	}

}
