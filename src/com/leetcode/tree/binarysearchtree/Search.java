package com.leetcode.tree.binarysearchtree;

import com.datastructure.tree.binarysearchtree.impl.BinarySearchTreeBuilder;
import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 700 (E)
 * Search in a Binary Search Tree
 */
public class Search {

    private static BinaryTreeNode searchBST(BinaryTreeNode root, int val) {
        if(root == null){
            return null;
        }

        BinaryTreeNode current = root;
        while(current != null){
            if(current.getData() < val){
                current = current.getRight();
            } else if(current.getData() > val){
                current = current.getLeft();
            } else {
                return current;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinarySearchTreeBuilder.tree();
        System.out.println(searchBST(root, 30));
    }
}
