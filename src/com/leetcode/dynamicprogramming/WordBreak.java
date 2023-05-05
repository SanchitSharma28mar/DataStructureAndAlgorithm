package com.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode: 139 (M)
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * ---
 *  Input: s = "leetcode", wordDict = ["leet","code"]
 *  Output: true
 *  Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

    private static boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap<>();
        return wordBreakUtil(s, wordDict, memo);
    }

    private static boolean wordBreakUtil(String s, List<String> wordDict, Map<String, Boolean> memo){
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        if(s.isEmpty()){
            return true;
        }
        for(String s1 : wordDict){
            if(s.indexOf(s1) == 0) {
                String wordAfterRemoval = s.substring(s1.length());
                if (wordBreakUtil(wordAfterRemoval, wordDict, memo)) {
                    memo.put(s, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }
}
