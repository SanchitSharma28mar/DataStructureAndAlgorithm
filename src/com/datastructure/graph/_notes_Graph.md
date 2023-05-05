Graph = Nodes(Vertices) + Edges

Types:
1. Directed Graph
2. Undirected Graph

Neighbour Node - Any adjacent node accessible from a node, obeying the direction of the edge.

Representation of Graph:
1. Adjacency List: Usually a HashMap where **[key = node, value = list/array of neighbours]** 
2. Adjacency Matrix: 


Traversal:
1. Depth First Traversal: Uses **Stack (iterative)** or **Stack frames (recursive)**
2. Breadth First Traversal: Uses **Queue**


**Spanning Tree:**
1. Subgraph S of a graph G
2. Should be connected
3. All nodes of graph G should be present in subgraph S.
4. Number of Edges in S = Number of Edges in G - 1

