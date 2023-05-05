package com.leetcode.slidingwindow;

/**
 * LeetCode: 567 (M)
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * ---
 *  Input: s1 = "ab", s2 = "eidbaooo"
 *  Output: true
 *  Explanation: s2 contains one permutation of s1 ("ba")
 */
public class Check_If_Any_Anagram_Present {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        int windowSize = s1.length();
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < s2.length(); windowEnd++){
            if(windowEnd - windowStart == windowSize - 1){
                boolean f = checkIfAnagram(s1, s2.substring(windowStart, windowEnd + 1));
                if(f){
                    return true;
                }
                windowStart++;
            }
        }
        return false;
    }

    private static boolean checkIfAnagram(String s1, String s2) {
        int[] arr = new int[26];
        for(char ch : s1.toCharArray())
            arr[ch - 'a']++;

        for(char ch : s2.toCharArray())
            arr[ch - 'a']--;

        for(int i : arr){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
