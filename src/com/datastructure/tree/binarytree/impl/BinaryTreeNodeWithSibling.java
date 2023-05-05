package com.datastructure.tree.binarytree.impl;

import lombok.Data;

@Data
public class BinaryTreeNodeWithSibling {
	int data;
	BinaryTreeNodeWithSibling left;
	BinaryTreeNodeWithSibling right;
	BinaryTreeNodeWithSibling nextSibling;
	@Override
	public String toString() {
		return this.getData() + "";
	}
}
