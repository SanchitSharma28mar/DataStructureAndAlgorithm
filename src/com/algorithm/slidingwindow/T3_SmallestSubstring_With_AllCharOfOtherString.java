package com.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s 
 * such that every character in t (including duplicates) is included in the window. 
 * If there is no such substring, return the empty string "".
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * 
 * @author sanchitsharma
 *
 */
public class T3_SmallestSubstring_With_AllCharOfOtherString {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String p = "ABC";
		String smallestSubstring = findSmallestSubstring(s, p);
		System.out.println(smallestSubstring);
	}
	private static String findSmallestSubstring(String s, String p) {
		if (s.length() == 0 || p.length() == 0) {
            return "";
        }

        Map<Character, Integer> pMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            int count = pMap.getOrDefault(ch, 0);
            pMap.put(ch, count + 1);
        }

        int requiredUniqueCharCount = pMap.size();
        int actualUniqueCharCount = 0;
        int finalStart = 0;
        int finalEnd = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        char[] arr = s.toCharArray();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char currentChar = arr[windowEnd];
            int count = sMap.getOrDefault(currentChar, 0);
            sMap.put(currentChar, count + 1);

            if (pMap.containsKey(currentChar) 
            		&& pMap.get(currentChar) == sMap.get(currentChar)) {
                actualUniqueCharCount++;
            }
            
            while (windowStart <= windowEnd && actualUniqueCharCount == requiredUniqueCharCount) {
                char chatAtStart = arr[windowStart];
                int currentLength = windowEnd - windowStart + 1;
                if(minLength > currentLength) {
                	finalStart = windowStart;
                	finalEnd = windowEnd;
                	
                }
                sMap.put(chatAtStart, sMap.get(chatAtStart) - 1);
                if (pMap.containsKey(chatAtStart) 
                		&& sMap.get(chatAtStart) < pMap.get(chatAtStart)) {
                    actualUniqueCharCount--;
                }
                windowStart++;
            }
        }
        return s.substring(finalStart, finalEnd + 1);
	}
}
