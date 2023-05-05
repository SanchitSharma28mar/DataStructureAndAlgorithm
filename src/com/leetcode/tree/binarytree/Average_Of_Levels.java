package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode: 637 (E)
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
 */
public class Average_Of_Levels {

    private static List<Double> averageOfLevels(BinaryTreeNode root) {
        List<Double> levelAvgs = new ArrayList<>();
        if(root == null){
            return levelAvgs;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int numberOfElementsNow = queue.size();
            double levelSum = 0;
            for(int i = 0; i < numberOfElementsNow; i++){
                BinaryTreeNode removed = queue.remove();
                if(removed.getLeft() != null)
                    queue.add(removed.getLeft());
                if(removed.getRight() != null)
                    queue.add(removed.getRight());
                levelSum += removed.getData();
            }
            Double levelAvg = Double.valueOf(levelSum/numberOfElementsNow);
            levelAvgs.add(levelAvg);
        }
        return levelAvgs;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeBuilder.tree();
        System.out.println(averageOfLevels(root));
    }
}
