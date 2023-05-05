package com.datastructure.linkedlist;

import java.util.Hashtable;
import java.util.Map;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_20_IntersectionMergePoint_HashTable {
	/**
	 * Idea:
	 *  Put one LL in HashMap
	 *  While putting second LL
	 *  if node is present => common node
	 *  first common node => merge point
	 * 
	 */
	public MySinglyNode intersectionMergePoint(MySinglyNode head1, MySinglyNode head2){
		MySinglyNode c1 = head1;
		Map<Integer, Integer> map = new Hashtable<Integer, Integer>();
		while(c1 != null){
			map.put((Integer)c1.getData(), 1);
			c1 = c1.getNext();
		}
		MySinglyNode c2 = head2;
		while(c2 != null){
			if(map.containsKey((Integer)c2.getData())){
				return c2;
			}
			c2 = c2.getNext();
		}
		return null;
	}
}
