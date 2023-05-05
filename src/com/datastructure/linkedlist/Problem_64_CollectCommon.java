package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_64_CollectCommon {
	
	private static MySinglyNode collectCommon(MySinglyNode list1, MySinglyNode list2) {
		MySinglyNode newHead = new MySinglyNode(0);
		MySinglyNode temp = newHead;
		while(list1 != null && list2 != null) {
			if(list1.getData() == list2.getData()) {
				temp.setNext(new MySinglyNode(list1.getData()));
				list1 = list1.getNext();
				list2 = list2.getNext();
				temp = temp.getNext();
			} else if((Integer)list1.getData() > (Integer)list2.getData()) {
				list2 = list2.getNext();
			} else if((Integer)list1.getData() < (Integer)list2.getData()) {
				list1 = list1.getNext();
			}
		}
		return newHead.getNext();
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
		
		MySinglyLinkedList linkedList2 = new MySinglyLinkedList();
		linkedList2.addAtLast(Integer.valueOf(4));
		linkedList2.addAtLast(Integer.valueOf(5));
		linkedList2.addAtLast(Integer.valueOf(6));
		linkedList2.addAtLast(Integer.valueOf(7));
		linkedList2.addAtLast(Integer.valueOf(8));
	
		MySinglyNode collectCommon = collectCommon(linkedList.getHead(), linkedList2.getHead());
		while(collectCommon != null) {
			System.out.println(collectCommon);
			collectCommon = collectCommon.getNext();
		}
	}
}
