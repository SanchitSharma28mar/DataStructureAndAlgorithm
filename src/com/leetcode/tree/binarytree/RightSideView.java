package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode: 199 (M)
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 */
public class RightSideView {

    private static List<Integer> rightSideView(BinaryTreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        if(root == null)
            return rightSideView;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                BinaryTreeNode popped = queue.remove();
                if(i == currentSize - 1)
                    rightSideView.add(popped.getData());
                if(popped.getLeft() != null)
                    queue.add(popped.getLeft());
                if(popped.getRight() != null)
                    queue.add(popped.getRight());
            }
        }
        return rightSideView;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeBuilder.tree();
        List<Integer> rightSideView = rightSideView(root);
        System.out.println(rightSideView);
    }
}
