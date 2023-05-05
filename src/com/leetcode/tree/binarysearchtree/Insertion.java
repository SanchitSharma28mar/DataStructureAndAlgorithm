package com.leetcode.tree.binarysearchtree;

import com.datastructure.tree.binarysearchtree.impl.BinarySearchTreeBuilder;
import com.datastructure.tree.binarytree.impl.BinaryTreeTraversal;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 701 (M)
 */
public class Insertion {

    private static BinaryTreeNode insert(BinaryTreeNode root, int data) {
        if(root == null){
            return new BinaryTreeNode(data);
        }

        if(root.getData() > data){
            root.setLeft(insert(root.getLeft(), data));
        }
        if(root.getData() < data){
            root.setRight(insert(root.getRight(), data));
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinarySearchTreeBuilder.tree();
        BinaryTreeTraversal.levelOrderIterativeUsingQueue(root);
        BinaryTreeNode node = insert(root, 65);
        BinaryTreeTraversal.levelOrderIterativeUsingQueue(node);
    }
}
