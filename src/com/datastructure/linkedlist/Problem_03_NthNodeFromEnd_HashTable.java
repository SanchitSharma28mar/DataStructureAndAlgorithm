package com.datastructure.linkedlist;

import java.util.Hashtable;
import java.util.Map;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_03_NthNodeFromEnd_HashTable {
	
	/**
	 * Idea: 
	 * 	finding the size of table so that total number of elements can be found
	 * 	Then nTh node will be reached if we traverse the list to (m-n+1)th node
	 * 
	 * Space = O(n) | Time = O(n)
	 */
	public MySinglyNode nthNodeFromEnd(MySinglyNode head, int nTh){
		MySinglyNode c = head;
		Map<Integer, Integer> table = new Hashtable<>();
		int index = 1;
		while(c != null){
			table.put((Integer) c.getData(), index);
			index++;
			c = c.getNext();
		}
		int lenthOfTable = table.size();
		MySinglyNode node = null;
		if(lenthOfTable > nTh){
			int lengthToBeTraversed = lenthOfTable - nTh + 1;
			node = head;
			int i = 1;
			while(node != null && i <= lengthToBeTraversed){
				node = node.getNext();
			}
		}
		return node;
	}
}
