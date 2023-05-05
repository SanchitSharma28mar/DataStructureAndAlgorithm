package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.model.BinaryTreeNode;

public class Problem_65_FloorAndCeil {
	private static int INVALID = -1;
	// Ceiling of an element 'a' is defined as the smallest value from given data-set which is greater than or equal to element 'a'.
	public static int getCeil(BinaryTreeNode root, int value){
		if(root == null){
			return INVALID;
		}
		int ceiling = 0;
		if(root.getData() == value){
			ceiling = root.getData();
		} else if(root.getData() < value){
			ceiling = getCeil(root.getRight(), value);
		} else {
			ceiling = getCeil(root.getLeft(), value);
			if(ceiling == INVALID){
				ceiling = root.getData();
			}
		}
		return ceiling;
	}
	
	//	Floor of an element 'a' is defined as the largest value from given data-set which is less than or equal to element 'a'. 
	public static int getFloor(BinaryTreeNode root, int value){
		if(root == null){
			return INVALID;
		}
		int floor = 0;
		if(root.getData() == value){
			floor = root.getData();
		} else if(root.getData() > value){
			floor = getFloor(root.getLeft(), value);
		} else {
			floor = getFloor(root.getRight(), value);
			if(floor == INVALID){
				floor = root.getData();
			}
		}
		return floor;
	}
}
