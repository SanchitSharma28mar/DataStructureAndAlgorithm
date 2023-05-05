package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 110 (E)
 * Given a binary tree, determine if it is height-balanced
 */
public class CheckIf_Balanced {

    private static boolean isBalanced(BinaryTreeNode root){
        int height = findHeight(root);
        return height != -1 ? true : false;
    }

    private static int findHeight(BinaryTreeNode root) {
        // base case to stop recursion
        if(root == null){
            return 0;
        }
        // Find height of left subtree
        int leftSubtreeHeight = findHeight(root.getLeft());
        // if it is -1, then unbalanced
        if(leftSubtreeHeight == -1){
            return -1;
        }
        // Find height of right subtree
        int rightSubtreeHeight = findHeight(root.getRight());
        // if it is -1, then unbalanced
        if(rightSubtreeHeight == -1){
            return -1;
        }
        // Check if subtree is balanced or not
        if(Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1){
            return -1;
        }
        // height of the subtree
        return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeBuilder.tree();
        System.out.println(isBalanced(root));
    }

}
