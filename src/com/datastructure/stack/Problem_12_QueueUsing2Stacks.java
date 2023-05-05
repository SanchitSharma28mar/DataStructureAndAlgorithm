package com.datastructure.stack;

import java.util.Stack;

public class Problem_12_QueueUsing2Stacks {
	/**
	 * Idea:
	 * 	two stacks are used
	 * 	one for enqueue and other for dequeue
	 * 	enqueue all to enqueStack
	 * 	while dequeue check dequeStack.isEmpty 
	 * 		=> true, pop all from enqueStack 
	 * 			and push to dequeStack
	 * 			and pop from dequeuStack
	 * 
	 */
	
	private static Stack<Character> enqueStack = new Stack<>();
	private static Stack<Character> dequeStack = new Stack<>();
	
	public static void enqueue(char ch){
		enqueStack.push(ch);
	}
	public static char dequeue(){
		if(dequeStack.isEmpty()){
			while(!enqueStack.isEmpty()){
				dequeStack.push(enqueStack.pop());
			}
		} 
		return dequeStack.pop();
	}
	
	public static void main(String[] args) {
		enqueue('a');
		enqueue('b');
		enqueue('c');
		System.out.println("Enqueue Stack");
		for(Character ch : enqueStack) {
			System.out.print(ch + " ");
		}
		System.out.println();
		System.out.println("Dequeue Stack");
		for(Character ch : dequeStack) {
			System.out.print(ch + " ");
		}
		
		System.out.println("Dequeing : " + dequeue());
		System.out.println("Enqueue Stack");
		for(Character ch : enqueStack) {
			System.out.print(ch + " ");
		}
		System.out.println();
		System.out.println("Dequeue Stack");
		for(Character ch : dequeStack) {
			System.out.print(ch + " ");
		}
		System.out.println();
		enqueue('d');
		System.out.println("Enqueue Stack");
		for(Character ch : enqueStack) {
			System.out.print(ch + " ");
		}
		System.out.println();
		System.out.println("Dequeue Stack");
		for(Character ch : dequeStack) {
			System.out.print(ch + " ");
		}
		System.out.println();
		System.out.println("Dequeing : " + dequeue());
		System.out.println("Enqueue Stack");
		for(Character ch : enqueStack) {
			System.out.print(ch + " ");
		}
		System.out.println();
		System.out.println("Dequeue Stack");
		for(Character ch : dequeStack) {
			System.out.print(ch + " ");
		}
	}
}
