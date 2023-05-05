package com.datastructure.graph.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphBuilder {

    // Adjacency List representation
    public static Map<String, List<String>> directedGraph_AdjacencyList(){
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("a", List.of("b", "c"));
        graph.put("b", List.of("d"));
        graph.put("c", List.of("e"));
        graph.put("d", List.of("f"));
        graph.put("e", List.of());
        graph.put("f", List.of("g", "i"));
        graph.put("g", List.of("h"));
        graph.put("h", List.of());
        graph.put("i", List.of("g", "k"));
        graph.put("j", List.of("i"));
        graph.put("k", List.of());
        return graph;
    }

    public static String[][] undirectedGraph_EdgeList(){
        String[][] edgeList = {
                {"i", "j"},
                {"k", "i"},
                {"m", "k"},
                {"k", "l"},
                {"o", "n"}
        };
        return edgeList;
    }

    public static Map<String, List<String>> convert_Undirected(String[][] edgeList){
        Map<String, List<String>> graph = new HashMap<>();
        for (String[] edge : edgeList) {
            String a = edge[0];
            String b = edge[1];
            List<String> neighboursA = graph.getOrDefault(a, new ArrayList<>());
            neighboursA.add(b);
            graph.put(a, neighboursA);
            List<String> neighboursB = graph.getOrDefault(b, new ArrayList<>());
            neighboursB.add(a);
            graph.put(b, neighboursB);
        }
        return graph;
    }
}
