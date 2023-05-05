package com.datastructure.graph;

import com.datastructure.graph.impl.GraphBuilder;

import java.util.*;

public class ShortestPath {

    private static int shortestPath(Map<String, List<String>> graph, String source, String destination){
        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(source, 0));
        visited.add(source);
        while(!queue.isEmpty()){
            Pair popped = queue.remove();
            int distance = popped.getDistance();
            if(popped.getNode().equals(destination)){
                return distance;
            }
            for(String neighbour : graph.get(popped.getNode())){
                if(!visited.contains(neighbour)){
                    queue.add(new Pair(neighbour, distance + 1));
                    visited.add(neighbour);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[][] edgeList = {
                {"w", "x"},
                {"x", "y"},
                {"z", "y"},
                {"z", "v"},
                {"w", "v"}
        };
        Map<String, List<String>> graph = GraphBuilder.convert_Undirected(edgeList);
        System.out.println(shortestPath(graph, "w", "z"));
    }
}
