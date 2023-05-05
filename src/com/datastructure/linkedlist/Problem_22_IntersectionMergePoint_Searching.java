package com.datastructure.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_22_IntersectionMergePoint_Searching {
	/**
	 * Idea:
	 * Put nodes of both LL in list
	 * Find first duplicate occurrence of a node
	 * => Merge point
	 * 
	 */
	public MySinglyNode intersectionMergePoint(MySinglyNode head1, MySinglyNode head2){
		MySinglyNode c1 = head1;
		List<MySinglyNode> list = new ArrayList<MySinglyNode>();
		while(c1 != null){
			list.add(c1);
			c1 = c1.getNext();
		}
		MySinglyNode c2 = head2;
		while(c2 != null){
			list.add(c2);
			c2 = c2.getNext();
		}
		
		MySinglyNode mergePoint = null;
		Set<MySinglyNode> set = new HashSet<MySinglyNode>();
		for (MySinglyNode node : list) {
			if(!set.contains(node)){
				set.add(node);
			} else {
				mergePoint = node;
				break;
			}
		}
		return mergePoint;
	}
}
