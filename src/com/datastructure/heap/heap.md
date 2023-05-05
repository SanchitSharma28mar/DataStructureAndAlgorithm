It offers both insertion and deletion in O(logN) time.
It’s the method of choice for implementing priority queues where speed is important and there will be many insertions.
A heap is a binary tree with these characteristics:
   • It’s complete. This means it’s completely filled in, reading from left to right across each row, although the last row need not be full.
   • It’s (usually) implemented as an array.
   • Each node in a heap satisfies the heap condition, which states that every node’s key is larger than (or equal to) the keys of its children.
For a node at index x in the array,
   • Its parent is (x-1) / 2.
   • Its left child is 2*x + 1. 
   • Its right child is 2*x + 2.
To trickle a node up or down means to move it along a path step by step, swapping it with the node ahead of it, checking at each step to see whether it’s in its proper position.


**MAX HEAP**
**Removal**:
Steps:
1. Remove the root.  maxNode = heapArray[0];
2. Move the last node into the root.  heapArray[0] = heapArray[N-1]; N--;
3. Trickle down the last node until it’s below a larger node and above a smaller one.

The last node is the rightmost node in the lowest occupied level of the tree. This corresponds to the last filled cell in the array.
At each position of the target node the trickle-down algorithm checks which child is larger. It then swaps the target node with the larger child.

**Insertion**:
Steps:
1. The node to be inserted is placed in the first open position at the end of the array.  heapArray[N] = newNode; N++;
2. The new node will usually need to be trickled upward until it’s below a node with a larger key and above a node with a smaller key.

The trickle-up algorithm is somewhat simpler than trickling down because two children don’t need to be compared. A node has only one parent, and the target 
node is simply swapped with its parent.


