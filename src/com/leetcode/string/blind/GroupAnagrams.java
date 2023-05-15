package com.leetcode.string.blind;

import java.util.*;

/**
 * LeetCode: 49 (M)
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * ---
 *  Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] arr = new int[26];
            for(char ch : s.toCharArray())
                arr[ch - 'a']++;

            String key = Arrays.toString(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

}
