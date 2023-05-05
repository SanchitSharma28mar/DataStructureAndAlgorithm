package com.leetcode.graph;

import java.util.*;
import java.util.Map.Entry;

/**
 * LeetCode: 323 (M)
 */
public class ConnectedComponents {

    private static int connectedComponentCount(Map<Integer, List<Integer>> graph){
        int connectedComponentCount = 0;
        Set<Integer> visited = new HashSet<>();
        for(int keyNode : graph.keySet()) {
            boolean newComponent = traversal_DFS(graph, keyNode, visited);
            if(newComponent){
                connectedComponentCount += 1;
            }
        }
        return connectedComponentCount;
    }

    private static boolean traversal_DFS(Map<Integer, List<Integer>> graph, int currentNode, Set<Integer> visited) {
        if(visited.contains(currentNode)){
            return false;
        }
        visited.add(currentNode);
        List<Integer> neighbours = graph.get(currentNode);
        for(int neighbour : neighbours){
            traversal_DFS(graph, neighbour, visited);
        }

        return true;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = create();
        System.out.println(connectedComponentCount(graph));
    }

    private static Map<Integer, List<Integer>> create() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, List.of(8, 1, 5));
        graph.put(1, List.of(0));
        graph.put(5, List.of(0, 8));
        graph.put(8, List.of(0, 5));
        graph.put(2, List.of(3, 4));
        graph.put(3, List.of(2, 4));
        graph.put(4, List.of(3, 2));
        return graph;
    }
}
