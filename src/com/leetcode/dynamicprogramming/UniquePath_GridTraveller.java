package com.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 62: (M)
 * 	Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner
 * 	if it can only move down and right.
 * 
 * @author sanchitsharma
 *
 */
public class UniquePath_GridTraveller {
	public static void main(String[] args) {
		System.out.println("Memoized = " + gridTravellerMemoized(23, 13));
		System.out.println("Recursive = " + gridTravellerRecursive(23, 13));
		
	}

	private static int gridTravellerRecursive(int m, int n) {
		if(m == 0 || n == 0) {
			return 0;
		}
		if(m == 1 && n ==1) {
			return 1;
		}
		return gridTravellerRecursive(m - 1, n) + gridTravellerRecursive(m, n - 1);
	}
	
	/*
	 * Dynamic Programming Implementation [Memoization]
	 */
	private static int gridTravellerMemoized(int m, int n) {
		Map<String, Integer> memo = new HashMap<>();
		return gridTravellerMemoizedUtil(m, n, memo);
	}
	private static int gridTravellerMemoizedUtil(int m, int n, Map<String, Integer> memo) {
		String key = m + "," + n;
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		if(m == 0 || n == 0) {
			return 0;
		}
		if(m == 1 && n ==1) {
			return 1;
		}
		memo.put(key, gridTravellerMemoizedUtil(m - 1, n, memo) + gridTravellerMemoizedUtil(m, n - 1, memo));
		return memo.get(key);
	}
	
	
}
