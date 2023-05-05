package com.algorithm.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Dynamic Size Sliding Window Variant
 * 
 * Print all maximum size subarrays having all distinct elements in them
 * Input: {5, 2, 3, 5, 4, 3}
 * Output: The largest subarrays with all distinct elements are:
 * 	{5, 2, 3}
 * 	{2, 3, 5, 4}
 * 	{5, 4, 3}
 * 
 * @author sanchitsharma
 *
 */
public class M5_AllPossibleSubarrays_HavingMaxSize_WithDistinctElements {
	public static void main(String[] args) {
		int[] arr = {5, 2, 3, 5, 4, 3};
		printMaxSizeSubarrays(arr);
	}

	private static void printMaxSizeSubarrays(int[] arr) {
		int windowStart = 0;
		int windowEnd = 0;
		Set<Integer> set = new HashSet<>();
		for(; windowEnd < arr.length; windowEnd++) {
			if(!set.contains(arr[windowEnd])) {
				set.add(arr[windowEnd]);
			} else {
				printArray(arr, windowStart, windowEnd);
				while(arr[windowEnd] != arr[windowStart]) {
					set.remove(arr[windowStart]);
					windowStart++;
				}
				if(arr[windowEnd] == arr[windowStart]) {
					set.remove(arr[windowStart]);
					windowStart++;
				}
				set.add(arr[windowEnd]);
			}
		}
		printArray(arr,  windowStart, windowEnd);
	}

	private static void printArray(int[] arr, int start, int end) {
		System.out.print("Printing - ");
		for(int i = start; i < end; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
