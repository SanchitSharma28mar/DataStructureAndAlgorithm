package com.leetcode.tree.blind;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode: 102 (M)
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 */
public class LevelOrderTraversal {

    private static List<List<Integer>> levelOrder(BinaryTreeNode root) {
        List<List<Integer>> traversalLevels = new ArrayList<>();
        if(root == null){
            return traversalLevels;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int currentQueueSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < currentQueueSize; i++) {
                BinaryTreeNode popped = queue.remove();
                level.add(popped.getData());
                if(popped.getLeft() != null)
                    queue.add(popped.getLeft());
                if(popped.getRight() != null)
                    queue.add(popped.getRight());
            }
            traversalLevels.add(level);
        }

        return traversalLevels;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeBuilder.tree();
        List<List<Integer>> traversalLevels = levelOrder(root);
        System.out.println(traversalLevels);
    }
}
