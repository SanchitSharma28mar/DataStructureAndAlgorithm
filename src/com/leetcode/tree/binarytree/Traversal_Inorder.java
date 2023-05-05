package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 94 (E)
 */
public class Traversal_Inorder {

    private static List<Integer> inorderTraversal(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalUtil(root, list);
        return list;
    }

    private static void inorderTraversalUtil(BinaryTreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        inorderTraversalUtil(root.getLeft(), list);
        list.add(root.getData());
        inorderTraversalUtil(root.getRight(), list);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeBuilder.tree();
        List<Integer> inorderTraversal = inorderTraversal(root);
        System.out.println(inorderTraversal);
    }
}
