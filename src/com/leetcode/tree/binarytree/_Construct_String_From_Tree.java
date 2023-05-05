package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 606 (E)
 * Given the root of a binary tree, construct a string consisting of parenthesis
 * and integers from a binary tree with the preorder traversal way, and return it.
 * ---
 *  Input: root = [1,2,3,4]
 *  Output: "1(2(4))(3)"
 *  Explanation: Originally, it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)"
 */
public class _Construct_String_From_Tree {

    private static String tree2str(BinaryTreeNode root) {


        return null;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeBuilder.tree();
        System.out.println(tree2str(root));
    }
}
