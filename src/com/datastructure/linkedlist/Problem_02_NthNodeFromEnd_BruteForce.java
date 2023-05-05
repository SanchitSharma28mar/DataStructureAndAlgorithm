package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_02_NthNodeFromEnd_BruteForce {

//  Start at First Node of the List (call it curNodePtr).
//  Assign curNodePtr to tmpPtr and count number of nodes after the curNodePtr.
//  If number of nodes after curNodePtr are equal to N nodes or tmpPtr reaches END then break. 
//	If tmPtr reaches END but count not equal to N then return since we can't find the Nth node from the end of the Singly Linked List.
//  Move the curNodePtr one step forward in the Linked List i.e curNodePtr now points to its next node in the list and start again from STEP-2.
	private static MySinglyNode nthNodeFromEnd(MySinglyNode head, int nTh, int totalLength){
		MySinglyNode curNodePtr = head;
		MySinglyNode tempPtr = null;
		while(curNodePtr != null){
			tempPtr = curNodePtr;
			int len = 0;
			while(tempPtr != null){
				len++;
				if(len == totalLength - nTh +1){
					break;
				}
				tempPtr  = tempPtr.getNext();
			}
			if(len == totalLength - nTh+1){
				break;
			}
			curNodePtr = curNodePtr.getNext();
		}
		return tempPtr;
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

		System.out.println(nthNodeFromEnd(linkedList.getHead(), 3, 8));
	}
}
