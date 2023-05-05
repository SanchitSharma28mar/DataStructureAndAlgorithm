package com.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem_01_ReversingQueue {
	/**
	 * Idea: Use one Stack.
	 * 	dequeue all elements from queue and push to stack
	 * 	pop all element from stack and enqueue back to queue
	 * 
	 */
	public static Queue<Integer> reverse(Queue<Integer> queue){
		Stack<Integer> stack = new Stack<Integer>();
		while(!queue.isEmpty()){
			stack.push(queue.remove());
		}
		while(!stack.isEmpty()){
			queue.add(stack.pop());
		}
		return queue;
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		System.out.print(queue);
		System.out.println();
		System.out.print(reverse(queue));
	}
}
