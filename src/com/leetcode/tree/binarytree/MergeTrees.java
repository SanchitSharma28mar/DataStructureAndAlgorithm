package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.binarytree.impl.BinaryTreeTraversal;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 617 (E)
 *
 */
public class MergeTrees {

    private static BinaryTreeNode mergeTrees(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
        int root1Val = root1 != null ? root1.getData() : 0;
        int root2Val = root2 != null ? root2.getData() : 0;
        BinaryTreeNode node = new BinaryTreeNode(root1Val + root2Val);

        node.setLeft(
                mergeTrees(
                        root1 != null && root1.getLeft() != null ? root1.getLeft() : null,
                        root2 != null && root2.getLeft() != null ? root2.getLeft() : null
                )
        );

        node.setRight(
                mergeTrees(
                        root1 != null && root1.getRight() != null ? root1.getRight() : null,
                        root2 != null && root2.getRight() != null ? root2.getRight() : null
                )
        );

        return node;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = BinaryTreeBuilder.tree();
        BinaryTreeTraversal.levelOrderIterativeUsingQueue(root1);
        BinaryTreeNode root2 = BinaryTreeBuilder.tree1();
        BinaryTreeTraversal.levelOrderIterativeUsingQueue(root2);

        BinaryTreeNode mergedRoot = mergeTrees(root1, root2);
        BinaryTreeTraversal.levelOrderIterativeUsingQueue(mergedRoot);
    }
}
