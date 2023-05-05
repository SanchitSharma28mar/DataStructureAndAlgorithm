package com.datastructure.linkedlist;

import java.util.HashMap;
import java.util.Map;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_62_RemoveDuplicatesFromUnorderedList_Map {
	/**
	 * Idea:
	 *  Iterate across list and put nodes in map and by using another pointer keep on making a new list
	 *  Before putting check if node is present or not
	 *  If present: go to next node and neglect the current one.
	 *  If not: put in map 
	 * 
	 */
	public static MySinglyNode removeDuplicates(MySinglyNode head){
		MySinglyNode c = head;
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		MySinglyNode p = null;
		while(c != null){
			if(map.containsKey(c.getData())){
				c = c.getNext();
				p.setNext(c);
			} else {
				map.put((Integer)c.getData(), true);
				p = c;
				c = c.getNext();
			}
		}
		return head;
	}
	public static void main(String[] args) {
		MySinglyLinkedList linkedList = new MySinglyLinkedList();
		linkedList.addAtLast(1);
		linkedList.addAtLast(4);
		linkedList.addAtLast(2);
		linkedList.addAtLast(2);
		linkedList.addAtLast(2);
		linkedList.addAtLast(2);
		linkedList.addAtLast(3);
		linkedList.addAtLast(4);
		MySinglyNode newHead = removeDuplicates(linkedList.getHead());
		while(newHead != null){
			System.out.print(newHead);
			newHead = newHead.getNext();
		}
	}
}
