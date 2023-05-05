package com.datastructure.linkedlist;

import java.util.Hashtable;
import java.util.Map;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_27_MiddleNode_HashTable {
	/**
	 * Idea: Similar to Problem 26
	 * Put all nodes on HashMap and get Size
	 * Iterate to half of size;
	 * 
	 */
	public MySinglyNode middleNode(MySinglyNode head){
		MySinglyNode c = head;
		int key = 0;
		Map<Integer, MySinglyNode> map = new Hashtable<Integer, MySinglyNode>();
		while(c != null){
			map.put(key+1, c);
			c = c.getNext();
		}
		int length = map.size();
		c = head;
		for (int i = 0; i < length/2; i++) {
			c = c.getNext();
		}
		return c;
	}
}
