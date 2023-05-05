package com.datastructure.stack;

import java.util.Stack;

public class Problem_10_IfPalindromeUsingStack {
	/**
	 * Idea:
	 * 	Push elements till the middle index
	 * 	check for equality between pop() element and next elements
	 * 
	 */
	public static boolean ifPalidrome(String str){
		int length = str.length();
		int mid = length/2;
		int index = 0;
		Stack<Character> stack = new Stack<>();
		char[] array = str.toCharArray();
		while(index != mid) {
			stack.push(array[index]);
			index++;
		}
		index++;
		
		while(index < array.length) {
			 if(stack.isEmpty()) {
				 return false;
			 }
			 if(stack.pop() != array[index]) {
				 return false;
			 }
			 index++;
		}
		return true;
	}
	public static void main(String[] args) {
		System.err.println(ifPalidrome("anitina"));
	}
}
