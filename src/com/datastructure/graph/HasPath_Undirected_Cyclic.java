package com.datastructure.graph;

import com.datastructure.graph.impl.GraphBuilder;

import java.util.*;

public class HasPath_Undirected_Cyclic {

    private static boolean hasPath_depthFirst_Recursive(Map<String, List<String>> graph, String source, String destination) {
        return hasPath_DFS_Util(graph, source, destination, new HashSet<>());
    }

    private static boolean hasPath_DFS_Util(Map<String, List<String>> graph, String source, String destination, Set<String> visitedSet){
        if(visitedSet.contains(source)){
            return false;
        }
        visitedSet.add(source);

        if(source.equals(destination)) {
            return true;
        }

        List<String> neighbours = graph.get(source);
        for(String neighbour : neighbours){
            boolean hasPath = hasPath_DFS_Util(graph, neighbour, destination, visitedSet);
            if(hasPath)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] edgeList = GraphBuilder.undirectedGraph_EdgeList();
        Map<String, List<String>> graph = GraphBuilder.convert_Undirected(edgeList);
        System.out.println(hasPath_depthFirst_Recursive(graph, "j", "m"));
     }

}
