package com.algorithm.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Dynamic Size Sliding Window + Auxiliary Data Structure Variant.
 * 
 * Find the longest substring of a string containing distinct character
 * Input: findlongestsubstring
 * Output: dlongest
 * 
 * Input: abbcdafeegh
 * Output: bcdafe
 * 
 * @author sanchitsharma
 *
 */
public class T1_LongestSubstring_With_DistinctCharacters {
	public static void main(String[] args) {
		String string = "findlongestsubstring";
		String expected = "dlongest";
		String longestSubstring = findLongestSubstring(string);
		System.out.println(longestSubstring);
		System.out.println(expected.equalsIgnoreCase(longestSubstring));
	}

	private static String findLongestSubstring(String string) {
		int finalStartIndex= 0;
		int finalEndIndex = 0;
		int windowStart = 0;
		char[] arr = string.toCharArray();
		Set<Character> set = new HashSet<>();
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			char charAtCurrentindex = arr[windowEnd];
			// Check before adding to set
			if(!set.contains(charAtCurrentindex)) {
				set.add(charAtCurrentindex);
			} else {
				set.add(charAtCurrentindex);
				// record finalStartIndex and finalEndIndex
				int maxDiff = finalEndIndex - finalStartIndex;
				int currentDiff = windowEnd - windowStart;
				if(maxDiff < currentDiff) {
					finalEndIndex = windowEnd;
					finalStartIndex = windowStart;
				}
				// Remove till the repeating element in the loop
				while(charAtCurrentindex != arr[windowStart]) {
					set.remove(arr[windowStart]);
					windowStart++;
				}
				// Remove the repeating element now
				set.remove(arr[windowStart]);
				windowStart++;
			}
		}
		return string.substring(finalStartIndex, finalEndIndex);
	}
}
