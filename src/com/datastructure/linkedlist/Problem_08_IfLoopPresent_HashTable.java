package com.datastructure.linkedlist;

import java.util.Hashtable;
import java.util.Map;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_08_IfLoopPresent_HashTable {
	/**
	 * Idea:
	 * 	Put each node in hashtable
	 * 	before putting check if it is available or not
	 * 	if present: loop detected
	 * 	if not: no loop
	 * 
	 * Space = O(n) : Time = O(n)
	 */
	public boolean ifLoop(MySinglyNode head){
		MySinglyNode c = head;
		boolean flag = false;
		Map<Integer, Integer> table = new Hashtable<Integer, Integer>();
		while(c != null){
			if(table.containsKey(c.getData())){
				flag = true;
				break;
			} else {
				table.put((Integer) c.getData(), 1);
			}
			c = c.getNext();
		}
		return flag;
	}
}
