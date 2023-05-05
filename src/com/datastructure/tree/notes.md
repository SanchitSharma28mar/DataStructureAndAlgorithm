`Tree (Abstract Data Type):`
1. It is a non-linear data structure in the sense that each node may point to number of nodes.
2. Order of elements is not important.
3. Terminology:
   * **Size of a Node** - Number of descendants of a Node plus Node.
   * **Height of a Node** - Maximum length of the path from that Node to the Deepest Leaf node. If Node doesn't have any child, height is 1.
   * **Depth of a Node** - Length of the path from the Root to that Node.
   * **Size of a Tree** - Number of nodes in a tree.
   * **Height of a Tree** - Maximum height of all the nodes in a tree (Same as Depth of Tree).
   * **Depth of a Tree** - Maximum depth of all the nodes in a tree (Same as Height of Tree).
   * **Diameter/Width of a Tree** - Number of nodes on the longest path between any two nodes. The route may or may not pass through root.
    
   
`Depth First Traversal:`
1. This is also called Pre-Order Traversal
2. Need to traverse all the way down first and then go laterally.
3. This can be implemented using Recursive approach and Iterative approach. 
4. Recursive approach internally uses a call stack 
5. Iterative approach would use a **_Stack_**. While using this, first thing that needs to be done is to push the root in Stack.


`Breadth First Traversal:`
1. This is also called Level Order Traversal
2. This can be implemented by **only** using Iterative approach.
3. Iterative approach would use a **_Queue_**.

`Binary Search Tree:`
1. leftData < rootData < rightData
2. There are no duplicates allowed.
3. Inorder traversal results in sorted list.
4. Inorder traversal is used to solve all the problem with a variation in the second step which is visiting the root.
5. The minimum element is the left most node which doesn't have the left child.
6. The maximum element is the right most node which doesn't have the right child.

