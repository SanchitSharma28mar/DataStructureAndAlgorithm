package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 144 (E)
 */
public class Traversal_Preorder {
    private static List<Integer> preorderTraversal(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderUtil(root, list);
        return list;
    }

    private static void preorderUtil(BinaryTreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        list.add(root.getData());
        preorderUtil(root.getLeft(), list);
        preorderUtil(root.getRight(), list);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeBuilder.tree();
        List<Integer> preorder = preorderTraversal(root);
        System.out.println(preorder);
    }
}
