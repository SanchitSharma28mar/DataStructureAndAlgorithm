package com.datastructure.graph.impl;

import java.util.*;

public class GraphTraversals {

    private static void depthFirst_Iterative(Map<String, List<String>> graph, String startingNode){
        Stack<String> stack = new Stack<>();
        stack.add(startingNode);
        while(!stack.empty()){
            String popped = stack.pop();
            System.out.print( popped + " ");
            stack.addAll(graph.get(popped));
        }
        System.out.println();
    }


    private static void depthFirst_Recursive(Map<String, List<String>> graph, String startingNode) {
        System.out.print( startingNode + " ");
        List<String> neighbours = graph.get(startingNode);
        neighbours.forEach(neighbour -> depthFirst_Recursive(graph, neighbour));
    }

    private static void breadthFirst(Map<String, List<String>> graph, String startingNode) {
        Queue<String> queue = new LinkedList<>();
        queue.add(startingNode);
        while(!queue.isEmpty()){
            String dequeued = queue.remove();
            System.out.print( dequeued + " ");
            queue.addAll(graph.get(dequeued));
        }
        System.out.println();
     }

    public static void main(String[] args) {
        Map<String, List<String>> graph = GraphBuilder.directedGraph_AdjacencyList();
        depthFirst_Iterative(graph, "a");
        depthFirst_Recursive(graph, "a");
        System.out.println();
        breadthFirst(graph, "a");
    }

}
