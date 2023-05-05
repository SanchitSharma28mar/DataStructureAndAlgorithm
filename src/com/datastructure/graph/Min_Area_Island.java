package com.datastructure.graph;

import java.util.HashSet;
import java.util.Set;

public class Min_Area_Island {

    private static int minAreaIsland(char[][] grid){
        int minArea = Integer.MAX_VALUE;

        Set<String> visitedPosition = new HashSet<>();
        int rows = grid.length;
        int columns = grid[0].length;

        for(int r = 0; r < rows; r++){
            for (int c = 0; c < columns; c++){
                int islandSize = traversal_DFS(grid, r, c, visitedPosition);
                if(islandSize > 0){
                    minArea = Math.min(minArea, islandSize);
                }
            }
        }

        return minArea;
    }

    private static int traversal_DFS(char[][] grid, int row, int column, Set<String> visitedPosition) {
        boolean checkRowBound = 0 <= row && row < grid.length;
        boolean checkColumnBound = 0 <= column && column < grid[0].length;
        if(!checkRowBound || !checkColumnBound){
            return 0;
        }
        if(grid[row][column] == 'W'){
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
        char[][] grid = {
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'W', 'W', 'L', 'W'},
                {'W', 'W', 'L', 'L', 'W'},
                {'L', 'W', 'W', 'L', 'L'},
                {'L', 'L', 'W', 'W', 'W'}
        };
        System.out.println(minAreaIsland(grid));
    }
}
