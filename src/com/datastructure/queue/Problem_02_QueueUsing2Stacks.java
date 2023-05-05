package com.datastructure.queue;

import java.util.Stack;

/**
 * Idea: 
 * Use 2 stacks.
 * enqueue in only one stack.
 * dequeue from only the other.
 *  
 * While dequeue
 * 		if 2nd is empty - > pop from s1 to s2 - pop s2
 * 		if 2nd not empty -> pop from s2
 * 
 * @author sanchitsharma
 *
 */
public class Problem_02_QueueUsing2Stacks {
	
	private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> s2 = new Stack<>();
	
	public void enqueue(int d) {
		s1.push(d);
	}
	
	public int dequeue() {
		if(s2.isEmpty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
}
