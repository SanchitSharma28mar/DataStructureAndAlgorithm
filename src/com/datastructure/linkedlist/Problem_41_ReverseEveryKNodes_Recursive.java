package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_41_ReverseEveryKNodes_Recursive {
	
	/**
	 * Idea: 
	 * 	Basic idea of reversing a list but till k
	 * 	
	 */
	public static MySinglyNode reverseKNodes(MySinglyNode head, int k){
		MySinglyNode c = head;
		MySinglyNode p = null;
		MySinglyNode n = null;
		int count = 0;
		// Reverse till k
		while(c != null && count < k){
			n = c.getNext();
			c.setNext(p);
			p = c;
			c = n;
			count++;
		}
		// Set current head's next as head from next reversal.
		if(n != null){
			head.setNext(reverseKNodes(n, k));
		}
		return p;
	}
	public static void main(String[] args) {
		MySinglyLinkedList linkedList = new MySinglyLinkedList();
		linkedList.addAtLast(1);
		linkedList.addAtLast(2);
		linkedList.addAtLast(3);
		linkedList.addAtLast(4);
		linkedList.addAtLast(5);
		linkedList.addAtLast(6);
		linkedList.addAtLast(7);
		linkedList.addAtLast(8);
		for(int i = 0 ; i < linkedList.getSize() ; i++){
			System.out.print(linkedList.getObject(i)+" ");
		}
		System.out.println("========================");
		MySinglyNode newHead = reverseKNodes(linkedList.getHead(), 3);
		while(newHead != null){
			System.out.print(newHead.getData()+" ");
			newHead = newHead.getNext();
		}
	}
}
