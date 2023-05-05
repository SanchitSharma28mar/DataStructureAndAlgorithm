package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 145 (E)
 */
public class Traversal_Postorder {
    private static List<Integer> postOrderTraversal(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderTraversalUtil(root, list);
        return list;
    }

    private static void postOrderTraversalUtil(BinaryTreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        postOrderTraversalUtil(root.getLeft(), list);
        postOrderTraversalUtil(root.getRight(), list);
        list.add(root.getData());
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeBuilder.tree();
        List<Integer> postOrder = postOrderTraversal(root);
        System.out.println(postOrder);
    }
}
