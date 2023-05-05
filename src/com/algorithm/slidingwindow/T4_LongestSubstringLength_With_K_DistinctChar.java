package com.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic Size Sliding Window + Auxiliary Data Structure Variant.
 * 
 * Find the length of the longest substring containing 'k' distinct characters
 * 
 * @author sanchitsharma
 *
 */
public class T4_LongestSubstringLength_With_K_DistinctChar {
	public static void main(String[] args) {
		String string = "AAAHIHHIBC";
		int k = 2;
		int longestSubstringLength = findLongestSubstringLength(string, k);
		System.out.println(longestSubstringLength);
	}

	private static int findLongestSubstringLength(String string, int k) {
		int maxLength = Integer.MIN_VALUE;
		int windowStart = 0;
		Map<Character, Integer> map = new HashMap<>();
		char[] arr = string.toCharArray();
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			// Put the character in the map
			char charEnd = arr[windowEnd];
			if(!map.containsKey(charEnd)) {
				map.put(charEnd, 1);
			} else {
				map.put(charEnd, map.get(charEnd) + 1);
			}
			// Check if more than k characters are present
			if(map.size() > k) {
				// Delete value of the key till a condition where size == k
				while(map.size() > k) {
					// Deletion
					char startChar = arr[windowStart];
					map.put(startChar, map.get(startChar) - 1);
					// Delete the key if value of the key is 0
					if(map.get(startChar) == 0) {
						map.remove(startChar);
					}
					// Shrink window
					windowStart++;
				}
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}
}
