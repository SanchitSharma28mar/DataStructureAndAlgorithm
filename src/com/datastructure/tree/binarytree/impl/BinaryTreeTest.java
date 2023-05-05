package com.datastructure.tree.binarytree.impl;

import com.datastructure.tree.model.BinaryTreeNode;

public class BinaryTreeTest {
	
	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
//		Problem_05_InsertionInBinaryTree.insertIterative(root, 10);
//		Problem_05_InsertionInBinaryTree.insertRecursiveLeft(root, 10);
//		Problem_05_InsertionInBinaryTree.insertRecursiveRight(root, 10);
//		Problem_08_DeleteTree.delete(root);
//		Problem_09_ReverseLevelOrder.reverseLevelOrder(root);
//		System.out.println(Problem_10_HeightOfBinaryTreeRecursive.height(root));
//		System.out.println(Problem_12_HeightOfBinaryTreeIterativeUsingQueue.height(root));
//		System.out.println(Problem_13_MinimumDepth.minDepthIterativeUsingQueue(root));
//		System.out.println(Problem_13_MinimumDepth.minDepthRecursive(root));
//		System.out.println(Problem_14_DeepestNode.deepestNode(root));
//		Problem_15_DeletingElement.deletingElement(root, 4);
//		System.out.println(Problem_16_NumberOfLeaves.numberOfLeaves(root));
//		System.out.println(Problem_17_NumberOfFullNodes.numberOfFullNodes(root));
//		System.out.println(Problem_18_NumberOfHalfNodes.numberOfHalfNodes(root));
//		System.out.println(Problem_19_CheckTwoTreesAreStructurallyIdentical.checkIfIdenticalRecursive(root, root2));
//		System.out.println(Problem_19_CheckTwoTreesAreStructurallyIdentical.checkIfIdenticalIterative(root, root2));
//		System.out.println(Problem_20_DiameterOfBinaryTree.getDiameter(root));
//		System.out.println(Problem_21_WidthOfBinaryTree.getMaxWidth(root));
//		System.out.println(Problem_22_MaximumSumLevel.maximumSumLevel(root));
//		Problem_23_PrintAllRootToLeafPaths.printAllPaths(root);
//		System.out.println(Problem_24_PathWithGivenSum.hasPathWithGivenSumSolution2(root, 8));
//		System.out.println(Problem_25_SumOfAllElementsRecursive.sumOfAllElements(root));
//		System.out.println(Problem_26_SumOfAllElementsIterative.sumOfAllElements(root));
//		Problem_27_ConvertToMirror.mirrorIterative(root);
//		System.out.println(Problem_28_IfMirrors.ifMirrors(root, root3));
//		int[] inorder = new int[]{4,2,5,1,3};
//		int[] preorder = new int[]{1,2,4,5,3};
//		BinaryTreeNode constructedTree = _Problem_29_TreeFromInorderAndPreorder_Bug.constructTree(inorder, preorder);
//		BinaryTreeTraversal.inorderRecursive(constructedTree);
//		Problem_32_AllAncestors.allAncestor(root, 6);
//		Problem_34_ZigZagTraversal.zigzagTraversal(root);
//		String preorder38 = "ILILL";
//		BinaryTreeNode constructedTree2 = Problem_38_BinaryTreeSpecialCase.constructTree(preorder38);
//		BinaryTreeTraversal.preOrderRecursive(constructedTree2);
		
		
		
	}

	private static void testTraversal(BinaryTreeNode root) {
		System.out.println("Preorder Traversal Recursive");
		BinaryTreeTraversal.preOrderRecursive(root);
		System.out.println();
		System.out.println("Preorder Traversal Iterative");
		BinaryTreeTraversal.preOrderIterativeUsingStack(root);
		
		System.out.println("Inorder Traversal Recursive");
		BinaryTreeTraversal.inorderRecursive(root);
		System.out.println();
		System.out.println("Inorder Traversal Iterative");
		BinaryTreeTraversal.inorderIterativeUsingStack(root);
		
		System.out.println("PostOrder Traversal Recursive");
		BinaryTreeTraversal.postOrderRecursive(root);
		System.out.println();
		System.out.println("PostOrder Traversal Iterative");
		BinaryTreeTraversal.postOrderIterativeUsingTwoStack(root);
		System.out.println();
		System.out.println("PostOrder Traversal Iterative");
		BinaryTreeTraversal.postOrderIterativeUsingOneStack(root);
		
		System.out.println();
		System.out.println("LevelOrder Traversal Iterative");
		BinaryTreeTraversal.levelOrderIterativeUsingQueue(root);
	}
}
