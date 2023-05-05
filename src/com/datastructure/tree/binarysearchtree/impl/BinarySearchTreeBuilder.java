package com.datastructure.tree.binarysearchtree.impl;

import com.datastructure.tree.model.BinaryTreeNode;

public class BinarySearchTreeBuilder {

    public static BinaryTreeNode tree(){
        BinaryTreeNode root = new BinaryTreeNode(40);
        BinaryTreeNode a = new BinaryTreeNode(30);
        BinaryTreeNode b = new BinaryTreeNode(50);
        root.setLeft(a);
        root.setRight(b);

        BinaryTreeNode c = new BinaryTreeNode(25);
        BinaryTreeNode d = new BinaryTreeNode(35);
        a.setLeft(c);
        a.setRight(d);

        BinaryTreeNode e = new BinaryTreeNode(45);
        BinaryTreeNode f = new BinaryTreeNode(60);
        b.setLeft(e);
        b.setRight(f);
        return root;
    }


}
