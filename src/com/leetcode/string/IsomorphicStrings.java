package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: 205 (E)
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * ---
 *  Input: s = "egg", t = "add"
 *  Output: true
 * ---
 *  Input: s = "foo", t = "bar"
 *  Output: false
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "badc", t = "baba"; //s = "foo", t = "bar" => false
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (c2 != map.get(c1)){
                    return false;
                }
            } else {
                if (map.containsValue(c2)){
                    return false;
                }
                map.put(c1, c2);
            }
        }
        return true;
    }
}
