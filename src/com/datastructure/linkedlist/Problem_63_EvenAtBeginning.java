package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_63_EvenAtBeginning {
	
	/**
	 * Idea:
	 * Iterate the linked list and make two linked lists
	 * One where all the even nodes are present
	 * Other where all odd nodes are present.
	 * Make sure to unlink the even and odd nodes once the main list is done.
	 * Else it would attach all the nodes at the back of each node.
	 * 
	 */
	private static MySinglyNode evenAtBeginning(MySinglyNode listHead) {
		MySinglyNode finalListHead = new MySinglyNode(0);
		MySinglyNode evenHead = new MySinglyNode(0);
		MySinglyNode oddHead = new MySinglyNode(0);
		MySinglyNode tempEven = evenHead;
		MySinglyNode tempOdd = oddHead;
		while(listHead != null && listHead.getNext() != null) {
			if((Integer)listHead.getData() % 2 == 0) {
				tempEven.setNext(listHead);
				tempEven = tempEven.getNext();
			} else {
				tempOdd.setNext(listHead);
				tempOdd = tempOdd.getNext();
			}
			listHead = listHead.getNext();
		}
		
		// Make sure they both point to null.
		// If not done, last element irrespective of even or odd will be placed at either of the two lists.
		tempEven.setNext(null);
		tempOdd.setNext(null);
		// Check the last element and set accordingly.
		if((Integer)listHead.getData() % 2 == 0) {
			tempEven.setNext(listHead);
			tempEven = tempEven.getNext();
		} else {
			tempOdd.setNext(listHead);
			tempOdd = tempOdd.getNext();
		}
		// Add oddHead at current end of evenHead which is tempEven
		tempEven.setNext(oddHead.getNext());
		finalListHead.setNext(evenHead.getNext());
		return finalListHead.getNext();
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
		MySinglyNode evenAtBeginning = evenAtBeginning(linkedList.getHead());
		while(evenAtBeginning != null) {
			System.out.println(evenAtBeginning);
			evenAtBeginning = evenAtBeginning.getNext();
		}
	}
}
