package com.leetcode.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode: 200 (M)
 */
public class Number_Of_Islands {

    private static int numIslands(char[][] grid) {
        int islandsCount = 0;

        int rows = grid.length - 1;
        int columns = grid[0].length - 1;
        Set<String> visited = new HashSet<>();
        for(int r = 0; r <= rows; r++){
            for(int c = 0; c <= columns; c++){
                boolean newIsland = traversal_DFS(grid, r, c, visited);
                if(newIsland)
                    islandsCount += 1;
            }
        }

        return islandsCount;
    }

    private static boolean traversal_DFS(char[][] grid, int row, int column, Set<String> visited) {
        boolean checkRowBound = 0 <= row && row < grid.length;
        boolean checkColumnBound = 0 <= column && column < grid[0].length;
        if(!checkRowBound || !checkColumnBound){
            return false;
        }
        if(grid[row][column] == 'W'){
            return false;
        }
        String position = row + "," + column;
        if(visited.contains(position)){
            return false;
        }
        visited.add(position);

        traversal_DFS(grid, row - 1, column, visited);
        traversal_DFS(grid, row + 1, column, visited);
        traversal_DFS(grid, row, column - 1, visited);
        traversal_DFS(grid, row, column + 1, visited);

        return true;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'W', 'W', 'L', 'W'},
                {'W', 'W', 'L', 'L', 'W'},
                {'L', 'W', 'W', 'L', 'L'},
                {'L', 'L', 'W', 'W', 'W'}
        };
        System.out.println(numIslands(grid));
    }
}
