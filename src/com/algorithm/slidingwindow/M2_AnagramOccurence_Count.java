package com.algorithm.slidingwindow;

/**
 * 
 * Fixed Size Sliding Window Variant
 * 
 * Given a word and a text, return the count of occurrences of the anagrams of the word in the text.
 * Input = "gotxxotgxdogt", word = "got"
 * Output = 3
 * 
 * @author sanchitsharma
 *
 */
public class M2_AnagramOccurence_Count {
	public static void main(String[] args) {
		String string1 = "gotxxotgxdogt";
		String string2 = "got";
		int count = findCount(string1, string2);
		System.out.println(count);
	}

	private static int findCount(String s, String p) {
		int count = 0;
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
					count++;
				}
				// Decrease the frequency for next iteration
				char charAtWindowStart = arr[i - (windowLength - 1)];
				sFreq[charAtWindowStart - 'a']--;
			}
		}
		return count;
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
