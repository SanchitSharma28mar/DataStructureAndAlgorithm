package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 572 (E)
 * Given the roots of two binary trees root and subRoot,
 * return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 */
public class CheckIf_Subtree {
    private static boolean isSubtree(BinaryTreeNode root, BinaryTreeNode subRoot) {
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }

        if(isSameTree(root, subRoot)){
            return true;
        }

        boolean isSameAsLeftSubtree= isSubtree(root.getLeft(), subRoot);
        boolean isSameAsRightSubtree= isSubtree(root.getRight(), subRoot);
        return isSameAsLeftSubtree || isSameAsRightSubtree;
    }

    private static boolean isSameTree (BinaryTreeNode root, BinaryTreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root.getData() != subRoot.getData()){
            return false;
        }
        boolean leftSubtreeIdentical = isSameTree(root.getLeft(), subRoot.getLeft());
        boolean rightSubtreeIdentical = isSameTree(root.getRight(), subRoot.getRight());
        return leftSubtreeIdentical && rightSubtreeIdentical;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeBuilder.tree();
        BinaryTreeNode subRoot = BinaryTreeBuilder.subTree();
        System.out.println(isSubtree(root, subRoot));
    }
}
