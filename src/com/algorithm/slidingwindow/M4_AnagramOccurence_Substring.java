package com.algorithm.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Fixed Size Sliding Window Variant
 * 
 * Find all substring of a string that are permutation of another string
 * Input: s = "XYYZXZYZXXYZ", p = "XYZ"
 * Output:
 * 	Anagram 'YZX' present at index 2
 *  Anagram 'XZY' present at index 4
 *  Anagram 'YZX' present at index 6
 *  Anagram 'XYZ' present at index 9
 * 
 * @author sanchitsharma
 *
 */
public class M4_AnagramOccurence_Substring {
	public static void main(String[] args) {
		String s = "XYYZXZYZXXYZ";
		String p = "XYZ";
		List<Integer> indexes = findIndexes(s, p);
		for(Integer index : indexes) {
			System.out.println("Anagram " + s.substring(index, index + p.length()) + " is present at index " + index);
		}
	}

	private static List<Integer> findIndexes(String s, String p) {
		List<Integer> indexes = new ArrayList<>();
		// Create frequency array for p
		int[] pFreq = new int[26];
		for(char ch : p.toCharArray()) {
			pFreq[ch - 'A']++;
		}
		int windowLength = p.length();
		int[] sFreq = new int[26];
		
		char[] arr = s.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			char charAtI = arr[i];
			//Increase the frequency in sFreq till the window length
			sFreq[charAtI - 'A']++;
			// sFreq has elements equal to windowLength
			if(i >= (windowLength - 1)) {
				boolean areSame = checkIfSame(sFreq, pFreq);
				if(areSame) {
					indexes.add(i - (windowLength - 1));
				}
				// Decrease the frequency for next iteration
				char charAtWindowStart = arr[i - (windowLength - 1)];
				sFreq[charAtWindowStart - 'A']--;
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
