package com.datastructure.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_23_IntersectionMergePoint_SearchingSorting {
	/**
	 * Idea:
	 *  Store nodes of one LL
	 *  Sort list
	 *  Check list with second LL
	 *  First equal node => Merge point
	 * 
	 */
	public MySinglyNode intersectionMergePoint(MySinglyNode head1, MySinglyNode head2){
		MySinglyNode c1 = head1;
		List<MySinglyNode> list = new ArrayList<MySinglyNode>();
		while(c1 != null){
			list.add(c1);
			c1 = c1.getNext();
		}
		Collections.sort(list);
		MySinglyNode c2 = head2;
		while(c2 != null){
			if(list.contains(c2)){
				return c2;
			}
			c2 = c2.getNext();
		}
		return null;
	}
}