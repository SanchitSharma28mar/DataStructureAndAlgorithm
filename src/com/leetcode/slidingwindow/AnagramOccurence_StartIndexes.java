package com.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 438 (M)
 * Fixed Size Sliding Window Variant
 * Given a string s, find all the start indices of another string p's anagrams in s.
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6] - substring with start index = 0 is "cba", substring with start index = 6 is "bac"  
 * 
 * @author sanchitsharma
 *
 */
public class AnagramOccurence_StartIndexes {
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> startIndexes = findIndexes(s, p);
		System.out.println("List of start indexes are - " + startIndexes);
	}

	private static List<Integer> findIndexes(String s, String p) {
		List<Integer> indexes = new ArrayList<>();
		// Create frequency array for p
		int[] pFreq = new int[26];
		for(char ch : p.toCharArray()) {
			pFreq[ch - 'a']++;
		}
		int windowLength = p.length();
		int[] sFreq = new int[26];
		
		char[] arr = s.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			char charAtI = arr[i];
			//Increase the frequency in sFreq till the window length
			sFreq[charAtI - 'a']++;
			// sFreq has elements equal to windowLength
			if(i >= (windowLength - 1)) {
				boolean areSame = checkIfSame(sFreq, pFreq);
				if(areSame) {
					indexes.add(i - (windowLength - 1));
				}
				// Decrease the frequency for next iteration
				char charAtWindowStart = arr[i - (windowLength - 1)];
				sFreq[charAtWindowStart - 'a']--;
			}
		}
		return indexes;
	}

	private static boolean checkIfSame(int[] sFreq, int[] pFreq) {
		for(int i = 0; i < 26; i++) {
			if(sFreq[i] != pFreq[i]) {
				return false;
			}
		}
		return true;
	}
}
