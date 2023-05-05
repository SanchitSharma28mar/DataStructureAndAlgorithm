package com.datastructure.tree.binarytree.impl;

import com.datastructure.tree.model.BinaryTreeNode;

public class BinaryTreeBuilder {
    public static BinaryTreeNode tree(){
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode a = new BinaryTreeNode(2);
        BinaryTreeNode b = new BinaryTreeNode(3);
        root.setLeft(a);
        root.setRight(b);
        BinaryTreeNode c = new BinaryTreeNode(4);
        BinaryTreeNode d = new BinaryTreeNode(5);
        a.setLeft(c);
        a.setRight(d);
        BinaryTreeNode e = new BinaryTreeNode(6);
        BinaryTreeNode f = new BinaryTreeNode(7);
        b.setLeft(e);
        b.setRight(f);
        BinaryTreeNode g = new BinaryTreeNode(8);
        BinaryTreeNode h = new BinaryTreeNode(9);
        c.setLeft(g);
        c.setRight(h);
        BinaryTreeNode i = new BinaryTreeNode(10);
        d.setLeft(i);

//        printBinaryTree(root, 4);
        return root;
    }

    public static BinaryTreeNode subTree(){
        BinaryTreeNode root = new BinaryTreeNode(4);
        BinaryTreeNode g = new BinaryTreeNode(8);
        BinaryTreeNode h = new BinaryTreeNode(9);
        root.setLeft(g);
        root.setRight(h);
        return root;
    }

    public static BinaryTreeNode tree1(){
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode a = new BinaryTreeNode(2);
        BinaryTreeNode b = new BinaryTreeNode(3);
        root.setLeft(a);
        root.setRight(b);
        BinaryTreeNode c = new BinaryTreeNode(4);
        BinaryTreeNode d = new BinaryTreeNode(5);
        a.setLeft(c);
        a.setRight(d);
        BinaryTreeNode e = new BinaryTreeNode(6);
        BinaryTreeNode f = new BinaryTreeNode(7);
        b.setLeft(e);
        b.setRight(f);
        BinaryTreeNode g = new BinaryTreeNode(8);
        BinaryTreeNode h = new BinaryTreeNode(9);
        c.setLeft(g);
        c.setRight(h);

//        printBinaryTree(root, 4);
        return root;
    }

    public static BinaryTreeNode mirroredTree(){
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode a = new BinaryTreeNode(3);
        BinaryTreeNode b = new BinaryTreeNode(2);
        root.setLeft(a);
        root.setRight(b);
        BinaryTreeNode c = new BinaryTreeNode(7);
        BinaryTreeNode d = new BinaryTreeNode(6);
        a.setLeft(c);
        a.setRight(d);
        BinaryTreeNode e = new BinaryTreeNode(5);
        BinaryTreeNode f = new BinaryTreeNode(14);
        b.setLeft(e);
        b.setRight(f);
        BinaryTreeNode g = new BinaryTreeNode(10);
        e.setRight(g);
        BinaryTreeNode h = new BinaryTreeNode(9);
        BinaryTreeNode i = new BinaryTreeNode(8);
        f.setLeft(h);
        f.setRight(i);

//        printBinaryTree(root, 4);
        return root;
    }

    public static void printBinaryTree(BinaryTreeNode root, int level){
        if(root==null)
            return;
        printBinaryTree(root.getRight(), level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
            System.out.println("|-------"+root.getData());
        }
        else
            System.out.println(root.getData());
        printBinaryTree(root.getLeft(), level+1);
    }

//    public static void main(String[] args) {
//        tree();
//    }
}
