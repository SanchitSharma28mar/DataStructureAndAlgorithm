package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 129 (M)
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * Each root-to-leaf path in the tree represents a number.
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers.
 * ---
 *  Input: root = [1,2,3]
 *  Output: 25
 *  Explanation:
 *      The root-to-leaf path 1->2 represents the number 12.
 *      The root-to-leaf path 1->3 represents the number 13.
 *      Therefore, sum = 12 + 13 = 25.
 */
public class SumRootToLeaf {

    private static void sumNumbers(BinaryTreeNode root, List<String> paths, String path){
        if(root == null){
            return;
        }
        if(root.getLeft() == null && root.getRight() == null){
            paths.add(path + root.getData());
        }

        path = path+root.getData();
        sumNumbers(root.getLeft(), paths, path);
        sumNumbers(root.getRight(), paths, path);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeBuilder.tree1();
        List<String> paths = new ArrayList<>();
        String path = "";
        sumNumbers(root, paths, path);
        System.out.println("All paths");
        paths.forEach(System.out::println);
        System.out.println("Sum of these paths");
        Integer sum = paths.stream().map(Integer::valueOf).reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
