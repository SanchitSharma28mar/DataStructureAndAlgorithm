package com.leetcode.graph;

import com.datastructure.graph.impl.GraphBuilder;

import java.util.*;

/**
 * LeetCode: 1971 (E)
 * Find if Path Exists in Graph
 */
public class HasPath {
    private static boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = convert_Undirected(edges);
        Set<Integer> visited = new HashSet<>();
        return validPathUtil(graph, source, destination, visited);
    }

    private static boolean validPathUtil(Map<Integer, List<Integer>> graph, int source,
                                         int destination, Set<Integer> visited) {
        if(visited.contains(source)){
            return false;
        }
        visited.add(source);
        if(source == destination){
            return true;
        }

        List<Integer> neighbours = graph.get(source);
        for(int neighbour : neighbours){
            if(validPathUtil(graph, neighbour, destination, visited)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0,1},
                {1,2},
                {2,0}
        };
        System.out.println(validPath(3, edges, 0, 2));
    }

    private static Map<Integer, List<Integer>> convert_Undirected(int[][] edgeList){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edgeList) {
            int a = edge[0];
            int b = edge[1];
            List<Integer> neighboursA = graph.getOrDefault(a, new ArrayList<>());
            neighboursA.add(b);
            graph.put(a, neighboursA);
            List<Integer> neighboursB = graph.getOrDefault(b, new ArrayList<>());
            neighboursB.add(a);
            graph.put(b, neighboursB);
        }
        return graph;
    }
}
