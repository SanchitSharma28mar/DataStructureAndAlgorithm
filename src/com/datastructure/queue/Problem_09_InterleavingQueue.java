package com.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_09_InterleavingQueue {
	/**
	 * Input [11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
	 * Output [11, 16, 12, 17, 13, 18, 14, 19, 15, 20]
	 * Idea:
	 * 	Use two queues
	 * 	Fill first by first half elements from  originalQueue
	 * 	Fill second by second half elements from  originalQueue
	 * 	Now, dequeue each queue one element at a time each and enqueue to originalQueue
	 * 
	 */
	public static Queue<Integer> interleavingQueue(Queue<Integer> queue){
		Queue<Integer> queueTemp1 = new LinkedList<Integer>();
		Queue<Integer> queueTemp2 = new LinkedList<Integer>();
		int k = queue.size()/2;
		int i = 0;
		while(!queue.isEmpty() && i < k){
			queueTemp1.add(queue.remove());
			i++;
		}
		while(!queue.isEmpty()){
			queueTemp2.add(queue.remove());
		}
		while(!queueTemp1.isEmpty() && !queueTemp2.isEmpty()){
			queue.add(queueTemp1.remove());
			queue.add(queueTemp2.remove());
		}
		return queue;
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(11);
		queue.add(12);
		queue.add(13);
		queue.add(14);
		queue.add(15);
		queue.add(16);
		queue.add(17);
		queue.add(18);
		queue.add(19);
		queue.add(20);
		System.out.println(queue);
		System.out.println(interleavingQueue(queue));
	}
}
