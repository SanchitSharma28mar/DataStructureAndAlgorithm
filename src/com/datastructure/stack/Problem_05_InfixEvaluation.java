package com.datastructure.stack;

import java.util.Stack;

public class Problem_05_InfixEvaluation {
	/**
	 * Idea:
	 * if whitespace => neglect and continue
	 * if number => append into string till char is between 0 and 9 as number can be of more than one digit 
	 * 			    and push in operand stack
	 * if opening bracket => push to operator stack
	 * if closing bracket => evaluate by two elements from operator and one from operator and push result to operand till operator.peek is '('
	 *						 pop from operatorStack
	 * if operator => check precedence between operator peek() and current char, if true, evaluate and push to operandStack, repeat till conditions meet
	 *                push current operator to operatorStack 
	 * 
	 * check !operatorStack.isEmpty() => evaluate
	 * 
	 */
	
	static Stack<Integer> operandStack = new Stack<Integer>();
	static Stack<Character> operatorStack = new Stack<Character>();

	public static Integer evaluate(String expression){
		char[] array = expression.toCharArray();
		for (int i = 0; i < array.length; i++) {

			// whitespace check - ignore
			if(array[i] == ' '){
				continue;
			}
			
			// if number push in operandStack
			if(array[i] >= '0' && array[i] <= '9'){
				// Number can be more than 1 digit
				StringBuilder sb = new StringBuilder();
				while(i < array.length && array[i] >= '0' && array[i] <= '9' ){
					sb.append(array[i++]);
				}
				operandStack.push(Integer.parseInt(sb.toString()));
			}
			// if '(' push in operatorStack
			else if(array[i] == '('){
				operatorStack.push(array[i]);
			}
			// if ')'
			else if(array[i] == ')'){
				while(operatorStack.peek() != '('){
					operandStack.push(util(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
				}
				operatorStack.pop();
			}
			// if operator
			else if(isOperator(array[i])){
				while(!operatorStack.isEmpty() && hasPrecedence(array[i], operatorStack.peek())){
					operandStack.push(util(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
				}
				operatorStack.push(array[i]);
			}
		}
		while(!operatorStack.isEmpty()){
			operandStack.push(util(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
		}
		return operandStack.pop();
	}
	private static boolean hasPrecedence(char c1, char c2) {
		if(c2 == ')' || c2 == '('){
			return false;
		} else if((c2 == '+' || c2 == '-') && (c1 == '*' || c1 == '/')){
			return false;
		} else{
			return true;			
		}
	}
	private static Integer util(Integer a, Integer b, Character operator) {
		switch (operator) {
		case '+':
			return b+a;
		case '-':
			return b-a;
		case '*':
			return b*a;
		case '/':
			return b/a;
		default:
			break;
		}
		return 0;
	}
	private static boolean isOperator(char operator){
		boolean flag = false;
		if('+' == operator || '-' == operator || '*' == operator || '/' == operator){
			flag = true;
		}
		return flag;
	}
	public static void main(String[] args) {
		System.out.println("10 + 2 * 6 = " + evaluate("10 + 2 * 6"));
		operandStack.removeAllElements();
		operatorStack.removeAllElements();
		System.out.println("100 * 2 + 12 = " + evaluate("100 * 2 + 12"));
		operandStack.removeAllElements();
		operatorStack.removeAllElements();
		System.out.println("100 * (2 + 12) = " + evaluate("100 * ( 2 + 12 )"));
		operandStack.removeAllElements();
		operatorStack.removeAllElements();
		System.out.println("100 * (2 + 12)/14 = " + evaluate("100 * ( 2 + 12 ) / 14"));
		operandStack.removeAllElements();
		operatorStack.removeAllElements();
	}
}
