package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_57_RotateRight {
	/**
	 * INPUT: 1 2 3 4 5 6 
	 * OUTPUT: 4 5 6 1 2 3
	 *  
	 * Idea:
	 *  Move the fast pointer by k-1 steps
	 *  Move slow and fast together by 1 step till fast.next!=null
	 *  Save next of slow in some variable. Break slows next.
	 *  Set fast's next as head.
	 *  Make slow's next as head.
	 */
	public static MySinglyNode rotateRight(MySinglyNode head, int k){
		MySinglyNode fast = head;
		MySinglyNode slow = head;
		for (int i = 1; i <= k; i++) {
			if(fast != null){
				fast = fast.getNext();
			}
		}
		while(fast != null && fast.getNext() != null){
			fast = fast.getNext();
			slow = slow.getNext();
		}
		MySinglyNode node = slow.getNext();
		slow.setNext(null);
		fast.setNext(head);
		head = node;
		return head;
	}
	public static void main(String[] args) {
		MySinglyLinkedList ll = new MySinglyLinkedList();
		ll.addAtLast(1);
		ll.addAtLast(2);
		ll.addAtLast(3);
		ll.addAtLast(4);
		ll.addAtLast(5);
		ll.addAtLast(6);
		
		MySinglyNode temp = ll.getHead(); 
		
		while(temp != null){
			System.out.print(temp);
			temp = temp.getNext();
		}
		System.out.println("");
		MySinglyNode node = rotateRight(ll.getHead(), 3);
		while (node != null) {
			System.out.print(node);
			node = node.getNext();
		}
	}
}
