package com.datastructure.graph;

import java.util.*;

public class LargestComponent {

    private static int largestComponentSize(Map<Integer, List<Integer>> graph){
        int largestComponentSize = Integer.MIN_VALUE;
        Set<Integer> visited = new HashSet<>();
        for(int keyNode : graph.keySet()){
            int currentComponentSize = traversal_DFS(graph, keyNode, visited);
            largestComponentSize = Math.max(largestComponentSize, currentComponentSize);
        }
        return largestComponentSize;
    }

    private static int traversal_DFS(Map<Integer, List<Integer>> graph, int keyNode, Set<Integer> visited) {
        if(visited.contains(keyNode))
            return 0;

        visited.add(keyNode);
        int size = 1;
        List<Integer> neighbours = graph.get(keyNode);
        for(int neighbour : neighbours){
            size += traversal_DFS(graph, neighbour, visited);
        }
        return size;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = create();
        System.out.println(largestComponentSize(graph));
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
