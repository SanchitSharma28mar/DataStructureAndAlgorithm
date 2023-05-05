package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 112 (E)
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a
 * root-to-leaf path such that adding up all the values along the path equals targetSum.
 */
public class CheckIf_HasPathSum {

    private static boolean hasPathSum(BinaryTreeNode root, int targetSum) {
        if(root == null){
            return  false;
        }

        targetSum -= root.getData();
        if(root.getLeft() == null && root.getRight() == null){
            return targetSum == 0;
        }
        return hasPathSum(root.getLeft(), targetSum) || hasPathSum(root.getRight(), targetSum);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeBuilder.tree();
        System.out.println(hasPathSum(root, 11));
        System.out.println(hasPathSum(root, 12));
        System.out.println(hasPathSum(root, 15));
    }
}
