package com.datastructure.graph;

import com.datastructure.graph.impl.GraphBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class HasPath_Directed_Acyclic {

    private static boolean hasPath_depthFirst_Recursive(Map<String, List<String>> graph, String source, String destination) {
        if (source.equals(destination)) {
            return true;
        }
        List<String> neighbours = graph.get(source);
        for(String neighbour : neighbours){
            if(hasPath_depthFirst_Recursive(graph, neighbour, destination)){
                return true;
            }
        }
        return false;
    }

    private static boolean hasPath_breadthFirst(Map<String, List<String>> graph, String source, String destination) {
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            String dequeued = queue.remove();
            if(dequeued.equals(destination)){
                return true;
            }
            queue.addAll(graph.get(dequeued));
        }
        return false;
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = GraphBuilder.directedGraph_AdjacencyList();
        System.out.println(hasPath_depthFirst_Recursive(graph, "f", "k"));
        System.out.println(hasPath_breadthFirst(graph, "f", "k"));
    }

}
