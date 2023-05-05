package com.datastructure.stack;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_13_StackUsing2Queues {
	/**
	 * Idea: 
	 * 	Since Stack is LIFO, on adding, remove all from Q1 and put in Q2
	 * 	Put new element in Q1, then put back all elements from Q2 to Q1
	 * 	At the push of every element, Q1 must be inverted.
	 *  Q2 is just for inverting the elements
	 * 
	 * 	One Queue only to pop
	 * 	Other Queue to push
	 * 	while pushing 
	 * 		=> if q1.isEmpty(), push to q1
	 * 		if !q1.isEmpty(), remove all from q1 and push to q2
	 * 						push current to q1
	 * 						remove all from q2 and push to q1
	 * 
	 */
	private static Queue<Character> q1 = new LinkedList<>();
	private static Queue<Character> q2 = new LinkedList<>();
	
	public static void push(char c){
		if(q1.isEmpty()){
			q1.offer(c);
		} else {
			while(!q1.isEmpty()){
				q2.offer(q1.poll());
			}
			q1.offer(c);
			while(!q2.isEmpty()){
				q1.offer(q2.poll());
			}
		}
	}
	public static char pop(){
		return q1.poll();
	}
}
