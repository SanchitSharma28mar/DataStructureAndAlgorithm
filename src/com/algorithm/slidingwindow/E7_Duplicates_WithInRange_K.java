package com.algorithm.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Fixed Size Sliding Window + Auxiliary Data Structure Variant.
 * 
 * Given an array and a positive number k, check whether the array contains any duplicate elements within the range k.
 * Input: { 5, 6, 8, 2, 4, 6, 9 }, k = 4
 * Output: true
 * 
 * Input: { 5, 6, 8, 2, 4, 6, 9 }, k = 2
 * Output: false
 * 
 * @author sanchitsharma
 *
 */
public class E7_Duplicates_WithInRange_K {
	public static void main(String[] args) {
		int[] arr = { 5, 6, 8, 2, 4, 6, 9 };
		int k = 4;
		boolean isDuplicateFound = checkIfDuplicatesInRange(arr, k);
		System.out.println(isDuplicateFound);
	}

	private static boolean checkIfDuplicatesInRange(int[] arr, int k) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < arr.length; i++) {
			if(set.contains(arr[i])) {
				return true;
			}
			set.add(arr[i]);
			if(i >= k) {
				set.remove(arr[i - k]);
			}
		}
		return false;
	}
}
