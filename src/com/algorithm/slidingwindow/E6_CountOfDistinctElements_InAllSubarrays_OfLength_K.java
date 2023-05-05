package com.algorithm.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Fixed Size Sliding Window Variant
 * 
 * Find the count of distinct elements in every subarray of size k
 * Input: { 2, 1, 2, 3, 2, 1, 4, 5 }, k = 5
 * Output:
 * 	The count of distinct elements in subarray { 2, 1, 2, 3, 2 } is 3
 *  The count of distinct elements in subarray { 1, 2, 3, 2, 1 } is 3
 *  The count of distinct elements in subarray { 2, 3, 2, 1, 4 } is 4
 *  The count of distinct elements in subarray { 3, 2, 1, 4, 5 } is 5
 * 
 * @author sanchitsharma
 *
 */
public class E6_CountOfDistinctElements_InAllSubarrays_OfLength_K {
	public static void main(String[] args) {
		int[] arr = { 2, 1, 2, 3, 2, 1, 4, 5 };
		int k = 5;
		List<Integer> countofDistinctElements = findCountofDistinct(arr, k);
		System.out.println(countofDistinctElements);
	}

	private static List<Integer>  findCountofDistinct(int[] arr, int k) {
		List<Integer> numberOfDistinctElements = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
			if(i >= (k - 1)) {
//				System.out.print("he count of distinct elements in subarray ");
//				printArray(arr, i - (k - 1), i + 1);
//				System.out.print(" is " + map.keySet().size());
				numberOfDistinctElements.add(map.keySet().size());
//				System.out.println();
				map.put(arr[i - (k - 1)], map.get(arr[i - (k - 1)]) - 1);
			}
		}
		return numberOfDistinctElements;
	}

	/*private static void printArray(int[] arr, int start, int end) {
		for(int i = start; i < end; i++) {
			System.out.print(arr[i] + " ");
		}
	}*/
}
