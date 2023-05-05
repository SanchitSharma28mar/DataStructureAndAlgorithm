package com.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem_10_ReverseKElements {
	/**
	 * Idea:
	 * 	Use stack
	 * 	dequeue first k elements from queue and push to stack
	 * 	pop all stack elements and enqueue to queue
	 * 	this is add all k elements in reverse order at the end of queue
	 * 	dequeue elements till size - k + 1 and enqueue them back again to queue
	 * 
	 */
	public static Queue<Integer> reversekElements(Queue<Integer> queue, int k){
		Stack<Integer> stack = new Stack<>();
		int temp = 0;
		while(!queue.isEmpty() && temp < k){
			stack.push(queue.remove());
			temp++;
		}
		while(!stack.isEmpty()){
			queue.add(stack.pop());
		}
		for (int i = 0; i < queue.size() - k; i++) {
			queue.add(queue.remove());
		}
		return queue;
	}
	public static void main(String[] args) {
		Queue<Integer> queue  = new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		System.out.print(queue);
		System.out.println();
		System.out.println(reversekElements(queue, 3));
	}
}
