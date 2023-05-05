package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_34_ReverseInPairs {
	
	/**
	 * Idea:
	 * 	2nd node is made the new head.
	 * 	For each pair, next node is reversed.
	 * 	Keep in mind the next node of the reversed node would be next of next.	
	 * 	
	 */
	public static MySinglyNode pairReverse(MySinglyNode head){
        // If linked list is empty or there is only one node in list
		if(head == null || head.getNext() == null){
			return null;
		}
		
		MySinglyNode previous = head;
		MySinglyNode current = head.getNext();
		head = current; 
		while(true){
			MySinglyNode next = current.getNext();
			current.setNext(previous);
			if(next == null || next.getNext() == null){
				previous.setNext(next);
				break;
			}
			previous.setNext(next.getNext());
			previous = next;
			current = previous.getNext();
		}
		return head;
	}
	
	public static void main(String[] args) {
		MySinglyLinkedList linkedList = new MySinglyLinkedList();
		linkedList.addAtLast("1");
		linkedList.addAtLast("2");
		linkedList.addAtLast("3");
		linkedList.addAtLast("4");
		linkedList.addAtLast("5");
		linkedList.addAtLast("6");
		linkedList.addAtLast("7");
		for(int i = 0 ; i < linkedList.getSize() ; i++){
			System.out.print(linkedList.getObject(i)+" ");
		}
		System.out.println();
		System.out.println("<========================>");
		MySinglyNode newHead = pairReverse(linkedList.getHead());
		while(newHead != null){
			System.out.print(newHead.getData()+" ");
			newHead = newHead.getNext();
		}
	}
}
