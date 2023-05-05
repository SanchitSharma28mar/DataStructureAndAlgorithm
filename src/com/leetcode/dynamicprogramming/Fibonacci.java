package com.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: 509 (E)
 * 	Fibonacci Number
 * 
 * @author sanchitsharma
 *
 */
public class Fibonacci {
	public static void main(String[] args) {
		System.out.println("Memoized = " + fibonacciMemoized(50));
		System.out.println("Recursive = " + fibonacciRecursive(50));
	}

	private static long fibonacciRecursive(int n) {
		if(n <= 2) {
			return 1;
		}
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}
	
	/*
	 * Dynamic Programming Implementation [Memoization]
	 */
	private static long fibonacciMemoized(int n) {
		Map<Integer, Long> memo = new HashMap<>();
		return fibonacciMemoizedUtil(n, memo);
	}
	private static long fibonacciMemoizedUtil(int n, Map<Integer, Long> memo) {
		if(memo.containsKey(n)) {
			return memo.get(n);
		}
		if(n <= 2) {
			return 1;
		}
		memo.put(n, fibonacciMemoizedUtil(n - 1, memo) + fibonacciMemoizedUtil(n - 2, memo));
		return memo.get(n);
	}
}
