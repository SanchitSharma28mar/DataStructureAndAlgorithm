package com.datastructure.tree.binarysearchtree.impl;

import lombok.Data;

@Data
public class Model_DLLNode {
	private Model_DLLNode prev;
	private Model_DLLNode next;
	int data;
}
