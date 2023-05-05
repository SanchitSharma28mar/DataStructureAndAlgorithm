package com.datastructure.linkedlist.impl;

import java.util.Random;

public class MySkipLinkedList<T extends Comparable<T>, U>{
	class SkipNode {
		T key;
		U value;
		long level;
		SkipNode next;
		SkipNode down;
		public SkipNode(T key, U value, long l, SkipNode n, SkipNode down) {
			this.key = key;
			this.value = value;
			this.level = l;
			this.next = n;
			this.down = down;
		}
	}
	private SkipNode head;
	private Random random;
	private long size;
	private double p;
	
	public MySkipLinkedList() {
		head = new SkipNode(null, null, 0, null, null);
		random = new Random();
		p = 0.5;
	}
	
	private long level(){
		long level = 0;;
		while(level <= size && random.nextDouble() < p){
			level++;
		}
		return level;
	}
	
	public void add(T key, U value){
		long level = level();
		if(level > head.level){
			head = new SkipNode(null, null, level, null, null);
		}
		SkipNode curr = head;
		SkipNode last = null;
		while(curr != null){
			if(curr.next == null || curr.next.key.compareTo(key) > 0){
				if(level >= curr.level){
					SkipNode newNode = new SkipNode(key, value, curr.level, curr.next, null);
					if(last != null){
						last.down = newNode;
					}
					curr.next = newNode;
					last = newNode;
				}
				curr = curr.down;
				continue;
			} else if(curr.next.key.compareTo(key) == 0){
				curr.next.value = value;
				return;
			}
			curr = curr.next;
		}
		size++;
	}
	
	public boolean search(T key){
		return get(key) != null;
	}

	public U get(T key) {
		SkipNode c = head;
		while(c != null){
			if(c.next == null || c.next.key.compareTo(key) > 0){
				c = c.down;
				continue;
			} else if(c.next.key.compareTo(key) == 0){
				return c.next.value;
			}
			c = c.next;
		}
		return null;
	}
	public U remove(T key){
		U value = null;
		SkipNode c = head;
		while(c != null){
			if(c.next == null || c.next.key.compareTo(key) >= 0){
				if(c.next.key.compareTo(key) == 0){
					value = c.next.value;
					c.next = c.next.next;
				}
				c = c.down;
				continue;
			}
			c = c.next;
		}
		size--;
		return value;
	}
}