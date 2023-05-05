package com.leetcode.tree.binarysearchtree;

import com.datastructure.tree.binarysearchtree.impl.BinarySearchTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 285 (M)
 * Find inorder successor in a BST
 */
public class InorderSuccessor {

    private static BinaryTreeNode inorderSuccessor(BinaryTreeNode root, BinaryTreeNode p){
        BinaryTreeNode successor = null;
        BinaryTreeNode current = root;
        while(current != null){
            if(p.getData() >= current.getData()){
                current = current.getRight();
            } else {
                // successor is a potential answer
                successor = current;
                current = current.getLeft();
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinarySearchTreeBuilder.tree();
        System.out.println("inorderSuccessor of 35 = " + inorderSuccessor(root, new BinaryTreeNode(35)));
        System.out.println("inorderSuccessor of 45 = " + inorderSuccessor(root, new BinaryTreeNode(45)));

    }
}
