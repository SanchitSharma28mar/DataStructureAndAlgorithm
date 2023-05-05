package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeTraversal;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: 106 (M)
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree
 * and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 */
public class Construct_Using_InorderAndPostorder {

    private static Map<Integer, Integer> inorderPositionMap = new HashMap<>();

    private static BinaryTreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0){
            return null;
        }

        for (int i = 0; i < inorder.length; i++)
            inorderPositionMap.put(inorder[i], i);
        int postorderLow = 0;
        int postorderHigh = postorder.length - 1;
        int inorderLow = 0;
        int inorderHigh = inorder.length - 1;
        return buildTreeUtil(inorderLow, inorderHigh,
                            postorder, postorderLow, postorderHigh);
    }

    private static BinaryTreeNode buildTreeUtil(int inorderLow, int inorderHigh,
                                                int[] postorder, int postorderLow, int postorderHigh) {
        // Base case
        if (inorderLow > inorderHigh || postorderLow > postorderHigh){
            return null;
        }

        // Create a node with last index of postorder[]
        int nodeValue = postorder[postorderHigh];
        BinaryTreeNode node = new BinaryTreeNode(nodeValue);

        // Index of nodeValue in inorder[]
        int inorderIndex = inorderPositionMap.get(nodeValue);

        // Build left subtree
        int leftSize = inorderIndex - inorderLow;
        int rightSize = inorderHigh - inorderIndex;
        node.setLeft(buildTreeUtil(inorderLow, inorderIndex - 1,
                postorder, postorderLow, postorderLow + leftSize - 1));
        // Build right subtree
        node.setRight(buildTreeUtil(inorderIndex + 1, inorderHigh,
                postorder, postorderHigh - rightSize, postorderHigh - 1));
        return node;
    }


    public static void main(String[] args) {
        int[] inorder = {8, 4, 9, 2, 10, 5, 1, 6, 3, 7};
        int[] postorder = {8, 9, 4, 10, 5, 2, 6, 7, 3, 1};
        BinaryTreeNode binaryTreeNode = buildTree(inorder, postorder);
         BinaryTreeTraversal.levelOrderIterativeUsingQueue(binaryTreeNode);
    }
}