package com.leetcode.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode: 695 (M)
 */
public class Max_Area_Island {

    private static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        Set<String> visitedPosition = new HashSet<>();
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                int islandSize = traversal_DFS(grid, r, c, visitedPosition);
                if(islandSize > 0){
                    maxArea = Math.max(maxArea, islandSize);
                }
            }
        }

        return maxArea;
    }

    private static int traversal_DFS(int[][] grid, int row, int column, Set<String> visitedPosition) {
        boolean checkRowBounds = 0 <= row && row < grid.length;
        boolean checkColumnBounds = 0 <= column && column < grid[0].length;
        if(!checkRowBounds || !checkColumnBounds){
            return 0;
        }
        if(grid[row][column] == 0){
            return 0;
        }

        String position = row + "," + column;
        if(visitedPosition.contains(position)){
            return 0;
        }
        visitedPosition.add(position);

        int size = 1;
        size += traversal_DFS(grid, row - 1, column, visitedPosition);
        size += traversal_DFS(grid, row + 1, column, visitedPosition);
        size += traversal_DFS(grid, row, column - 1, visitedPosition);
        size += traversal_DFS(grid, row, column + 1, visitedPosition);
        return size;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }
}
