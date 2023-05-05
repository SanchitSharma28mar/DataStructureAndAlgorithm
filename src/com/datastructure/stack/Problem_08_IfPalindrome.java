package com.datastructure.stack;

public class Problem_08_IfPalindrome {
	/**
	 * Idea:
	 * 	two pointers, one from start, other from end
	 * 	check for equality of char at both indexes
	 * 
	 */
	public static void ifPalindrome(String str){
		char[] chArray = str.toCharArray();
		int i = 0;
		int j = chArray.length-1;
		while(i < j && chArray[i] == chArray[j]){
			i++;
			j--;
		}
		if(i == j){
			System.out.println("Palindrome");
		} else {
			System.out.println("Not a palindrome");
		}
	}
	public static void main(String[] args) {
		ifPalindrome("anitina");
	}
}
