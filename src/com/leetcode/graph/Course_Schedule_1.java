package com.leetcode.graph;

import java.util.*;

/**
 * LeetCode: 207 (M)
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first
 * if you want to take course ai.
 */
public class Course_Schedule_1 {
    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph =  convertToAdjList(numCourses, prerequisites);
        Set<Integer> visitedSet = new HashSet<>();

        for(int course : graph.keySet()){
            boolean traversal = traversal(graph, course, visitedSet);
            if(!traversal){
                return false;
            }
        }

        return true;
    }

    private static boolean traversal(Map<Integer, List<Integer>> graph, int course, Set<Integer> visitedSet) {
        if(visitedSet.contains(course)){
            return false;
        }
        List<Integer> prerequisites = graph.get(course);
        if(prerequisites.isEmpty()){
            return true;
        }
        visitedSet.add(course);
        for(int prerequisite : prerequisites){
            boolean canBeCompleted = traversal(graph, prerequisite, visitedSet);
            if(!canBeCompleted){
                return false;
            }
        }
        visitedSet.remove(course);
        graph.put(course, new ArrayList<>()); // Not required, but it reduces the time taken.
        return true;
    }

    private static Map<Integer, List<Integer>> convertToAdjList(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            graph.put(i, new ArrayList<>());

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);

        }
        return graph;
    }

    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {3, 4}
        };
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
