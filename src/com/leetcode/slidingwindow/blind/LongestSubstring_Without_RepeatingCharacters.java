package com.leetcode.slidingwindow.blind;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode: 3 (M)
 *  Given a string s, find the length of the longest substring without repeating characters.
 *  ---
 *   Input: s = "abcabcbb" Output: 3
 *  ---
 *   Input: s = "pwwkew" Output: 3
 *
 */
public class LongestSubstring_Without_RepeatingCharacters {

    private static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            char charAtWindowEnd = s.charAt(windowEnd);
            if(set.contains(charAtWindowEnd)){
                int indexOfFirstOccurrence = s.indexOf(charAtWindowEnd, windowStart);
                while(windowStart != indexOfFirstOccurrence){
                    set.remove(s.charAt(windowStart));
                    windowStart++;
                }
                windowStart++;
            }
            set.add(charAtWindowEnd);
            int currentLength = windowEnd - windowStart + 1;
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int lengthOfLongestSubstring = lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repeating characters = " + lengthOfLongestSubstring);
    }
}
