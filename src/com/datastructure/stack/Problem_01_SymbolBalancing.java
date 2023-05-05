package com.datastructure.stack;

import java.util.Stack;

public class Problem_01_SymbolBalancing {
	/**
	 * Idea:
	 * 	Use a stack and push element if it is ( or { or [
	 * 	if element is ) or } or ], pop element from stack and check for pairing
	 * 	if ')', pop '(' => True
	 * 	if '}', pop '{' => True
	 * 	if ']', pop '[' => True
	 * 	else false
	 * 	false also when !isEmpty()
	 */
	private static Stack<Character> stack = new Stack<Character>();
	
	private static boolean checkIfBalanced(String string) {
		boolean flag = false;
		for (int i = 0; i < string.length(); i++) {
			if('{' == string.charAt(i) || '[' == string.charAt(i) ||'(' == string.charAt(i)){
				stack.push(string.charAt(i));
			} else {
				flag = match(string.charAt(i));
			}
		}
		if(!stack.isEmpty())
			flag = false;
		return flag;
	}

	private static boolean match(char ch) {
		boolean flag = false;
		if(!stack.isEmpty()){
			switch (ch) {
			case '}':
				if('{' == stack.pop()){
					flag = true;
				}
				break;
			case ']':
				if('[' == stack.pop()){
					flag = true;
				}
				break;
			case ')':
				if('(' == stack.pop()){
					flag = true;
				}
				break;
			default:
				break;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		String string1 = "(A+B)-(C-D)";
		boolean ifBalanced1 = checkIfBalanced(string1);
		System.out.println(string1 + " : " + ifBalanced1);
		stack.removeAllElements();
		
		String string2 = "((A+B)-(C-D)";
		boolean ifBalanced2 = checkIfBalanced(string2);
		System.out.println(string2 + " : " + ifBalanced2);
		stack.removeAllElements();
		
		String string3 = "((A+B)-[C-D])";
		boolean ifBalanced3 = checkIfBalanced(string3);
		System.out.println(string3 + " : " + ifBalanced3);
		stack.removeAllElements();
		
		String string4 = "((A+B)-[C-D]}";
		boolean ifBalanced4 = checkIfBalanced(string4);
		System.out.println(string4 + " : " + ifBalanced4);
		stack.removeAllElements();
		
		String string5 = "()(()[()])";
		boolean ifBalanced5 = checkIfBalanced(string5);
		System.out.println(string5 + " : " + ifBalanced5);
		stack.removeAllElements();
	}
}