package com.datastructure.linkedlist;

import java.util.Stack;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_21_IntersectionMergePoint_Stack {
	/**
	 * Idea:
	 *  Put both LL in two stacks
	 *  poll both stacks till elements are same
	 *  when nodes don't match, merge point is node taken previously
	 * 
	 */
	public MySinglyNode intersectionMergePoint(MySinglyNode head1, MySinglyNode head2){
		MySinglyNode c1 = head1;
		MySinglyNode c2 = head2;
		Stack<MySinglyNode> s1 = new Stack<MySinglyNode>();
		Stack<MySinglyNode> s2 = new Stack<MySinglyNode>();
		while(c1 != null){
			s1.push(c1);
			c1 = c1.getNext();
		}
		while(c2 != null){
			s2.push(c2);
			c2 = c2.getNext();
		}
		MySinglyNode temp = null;
		while(!s1.isEmpty() && !s2.isEmpty() &&  (Integer)s1.peek().getData() == (Integer)s2.peek().getData()){
			temp = s1.pop();
			s2.pop();
		}
		return temp;
	}
}
