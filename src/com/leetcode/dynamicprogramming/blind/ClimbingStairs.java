package com.leetcode.dynamicprogramming.blind;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: 70 (E)
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * ---
 *  Input: n = 3
 *  Output: 3
 *  Explanation: There are three ways to climb to the top.
 *      1. 1 step + 1 step + 1 step
 *      2. 1 step + 2 steps
 *      3. 2 steps + 1 step
 */
public class ClimbingStairs {

    private static int climbStairsMemoized(int n, Map<Integer, Integer> memo) {
        if(n < 0){
            return 0;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if(n == 0){
            memo.put(n, 1);
            return 1;
        }
        memo.put(n, climbStairsMemoized(n - 1, memo) + climbStairsMemoized(n - 2, memo));
        return memo.get(n);
    }

    private static int climbStairs(int n) {
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(44));
        Map<Integer, Integer> memo = new HashMap<>();
        System.out.println(climbStairsMemoized(3, memo));
        memo = new HashMap<>();
        System.out.println(climbStairsMemoized(44, memo));
    }
}
