package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 1448 (M)
 * Given a binary tree root, a node X in the tree is named good
 * if in the path from root to X there are no nodes with a value greater than X.
 */
public class CountGoodNodes {

    private static int goodNodes(BinaryTreeNode root) {
        int countOfGoodNodes = goodNodesUtil(root, root.getData());
        return countOfGoodNodes;
    }

    private static int goodNodesUtil(BinaryTreeNode root, int currentMax){
        if(root == null){
            return 0;
        }

        int result = 0;
        if(root.getData() >= currentMax){
            result = 1;
        }
        currentMax = Math.max(root.getData(), currentMax);
        result += goodNodesUtil(root.getLeft(), currentMax);
        result += goodNodesUtil(root.getRight(), currentMax);
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeBuilder.tree();
        System.out.println(goodNodes(root));
    }
}
