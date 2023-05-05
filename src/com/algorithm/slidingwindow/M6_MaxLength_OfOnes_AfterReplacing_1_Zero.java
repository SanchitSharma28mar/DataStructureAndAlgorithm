package com.algorithm.slidingwindow;

/**
 * Dynamic Size Sliding Window Variant.
 * Find the index of 0 to be replaces with 1 to get a maximum length sequence of continuous 1's
 * Input: { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 }
 * Output: 7 - Index to be replaced is 7 to get sequence of length 6 containing all 1's
 * 
 * @author sanchitsharma
 *
 */
public class M6_MaxLength_OfOnes_AfterReplacing_1_Zero {
	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 };
		int expectedIndex = 7;
		int indexToBeReplacedFrom = findIndexToBeReplacedFrom(arr);
		System.out.println(expectedIndex == indexToBeReplacedFrom);
	}

	private static int findIndexToBeReplacedFrom(int[] arr) {
		int windowStart = 0;
		int countOfZero = 0;
		int latestRecordedIndex = 0;
		int finalStartIndex = 0;
		int finalEndIndex = 0;
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			// Increase the count of 0's
			if(arr[windowEnd] == 0) {
				countOfZero++;
				// Keep track of the latest index of 0
				latestRecordedIndex = windowEnd;
			}
			if(countOfZero > 1) {
				// Increase windowStart till 1 is reached and latestRecordedIndex is reached
				while(windowStart < latestRecordedIndex && arr[windowStart] != 1) {
					windowStart++;
				}
				if(finalEndIndex - finalStartIndex < windowEnd - windowStart) {
					finalEndIndex = windowEnd;
					finalStartIndex = windowStart;
				}
			}
		}
		
		return latestRecordedIndex;
	}
}
