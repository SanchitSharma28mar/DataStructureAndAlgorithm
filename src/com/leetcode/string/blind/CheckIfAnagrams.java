package com.leetcode.string.blind;

/**
 * LeetCode: 242 (E)
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * ---
 *  Input: s = "anagram", t = "nagaram"
 *  Output: true
 *
 */
public class CheckIfAnagrams {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] arr = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            arr[ch - 'a']--;
        }
        for(int i : arr){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
