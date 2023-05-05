package com.algorithm.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Dynamic Size Sliding Window Variant.
 * 
 * Find length of the longest substring that doesn't contain any vowels
 * Input: "codeforintelligents"
 * Output: 3 - nts
 * 
 * @author sanchitsharma
 *
 */
public class T2_LongestSubstringLength_WithoutVowels {
	public static void main(String[] args) {
		String string = "codeforintelligents";
		int length = findLongestSubstringLength(string);
		System.out.println(length);
	}

	private static int findLongestSubstringLength(String string) {
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		int maxLength = Integer.MIN_VALUE;
		char[] arr = string.toCharArray();
		int windowStart = 0;
		int windowEnd = 0;
		for(; windowEnd < arr.length; windowEnd++) {
			char currentChar = arr[windowEnd];
			if(vowels.contains(currentChar)) {
				maxLength = Math.max(maxLength, windowEnd - windowStart);
				// this will make windowStart to reach one index ahead of windowEnd
				while(windowStart <= windowEnd) {
					windowStart++;
				}
			}
		}
		return Math.max(maxLength, windowEnd - windowStart);
	}
}
