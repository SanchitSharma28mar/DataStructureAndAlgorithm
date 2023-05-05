package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_05_NthNodeFromEnd_BestSolution {
	
	/**
	 * Idea: 
	 *	 Maintain a distance of n between two iterating pointers.
	 *
	 * Space = O(1) : Time = O(n)
	 */
	private static MySinglyNode nthNodeFromEnd(MySinglyNode head, int nTh){
		MySinglyNode fastNode = head;
		MySinglyNode slowNode = head;
		for (int i = 0; i < nTh; i++) {
			if(fastNode.getNext() != null){
				fastNode = fastNode.getNext();
			}
		}
		while(fastNode != null && fastNode.getNext() != null){
			fastNode = fastNode.getNext();
			slowNode = slowNode.getNext();
		}
		return slowNode;
	}
	
	public static void main(String[] args) {
		MySinglyLinkedList linkedList = new MySinglyLinkedList();
		linkedList.addAtLast(Integer.valueOf(1));
		linkedList.addAtLast(Integer.valueOf(2));
		linkedList.addAtLast(Integer.valueOf(3));
		linkedList.addAtLast(Integer.valueOf(4));
		linkedList.addAtLast(Integer.valueOf(5));
		linkedList.addAtLast(Integer.valueOf(6));
		linkedList.addAtLast(Integer.valueOf(7));
		linkedList.addAtLast(Integer.valueOf(8));

		System.out.println(nthNodeFromEnd(linkedList.getHead(), 3));
	}
}