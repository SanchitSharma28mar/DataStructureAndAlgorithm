package com.leetcode.graph.blind;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode: 133 (M)
 */
public class Clone_Graph {

    private static GraphNode cloneGraph(GraphNode node) {
        if(node == null)
            return null;
        Map<Integer, GraphNode> map = new HashMap<>();
        return traversalClone(node, map);
    }

    private static GraphNode traversalClone(GraphNode node, Map<Integer, GraphNode> map){
        if(map.containsKey(node.val))
            return map.get(node.val);
        GraphNode cloned = new GraphNode(node.val);
        map.put(node.val, cloned);
        for(GraphNode neighbor : node.neighbors) {
            GraphNode newNeighbour = traversalClone(neighbor, map);
            cloned.neighbors.add(newNeighbour);
        }
        return cloned;
    }

    public static void main(String[] args) {

    }
}

@Data
class GraphNode {
    public int val;
    public List<GraphNode> neighbors;
    public GraphNode(int val){
        this.val = val;
    }
}
