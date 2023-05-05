package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;
import com.datastructure.tree.binarytree.impl.BinaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 297 (H)
 * Design an algorithm to serialize and deserialize a binary tree.
 */
public class Serialize_Deserialize {

    private static int index = 0;

    // Encodes a tree to a single string.
    private static String serialize(BinaryTreeNode root) {
        List<String> list = new ArrayList<>();
        preorderTraversal(root, list);
        return String.join(",", list);
    }

    private static void preorderTraversal(BinaryTreeNode root, List<String> list) {
        if(root == null){
            list.add("N");
            return;
        }

        list.add(String.valueOf(root.getData()));
        preorderTraversal(root.getLeft(), list);
        preorderTraversal(root.getRight(), list);

    }

    // Decodes your encoded data to tree.
    private static BinaryTreeNode deserialize(String data) {
        String[] nodeData = data.split(",");
        BinaryTreeNode root = deserializeUtil(nodeData);
        return root;
    }

    private static BinaryTreeNode deserializeUtil(String[] nodeData){
        if(nodeData[index].equals("N")){
            index++;
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode(Integer.valueOf(nodeData[index]));
        index++;
        node.setLeft(deserializeUtil(nodeData));
        node.setRight(deserializeUtil(nodeData));
        return node;
    }


    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeBuilder.tree();
        String serializedTree = serialize(root);
        System.out.println("Serialized Tree = " + serializedTree);

        BinaryTreeNode deserializedRoot = deserialize(serializedTree);
        BinaryTreeTraversal.levelOrderIterativeUsingQueue(deserializedRoot);
    }
}
