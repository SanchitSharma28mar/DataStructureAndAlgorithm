package com.leetcode.graph.blind;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode: 79 (M)
 */
public class Word_Search_1 {

    private static boolean exist(char[][] board, String word) {

        Set<String> visitedPosition = new HashSet<>();
        for(int row = 0; row < board.length; row++){
            for (int column = 0; column < board[0].length; column++) {
                boolean stringFound = traversal_DFS(board, row, column, visitedPosition, word, 0);
                if(stringFound){
                    return true;
                }

            }
        }
        return false;
    }

    private static boolean traversal_DFS(char[][] board, int row, int column, Set<String> visitedPosition, String word, int charPosition) {
        if(charPosition >= word.length()){
            return false;
        }
        boolean checkRowBound = 0 <= row && row < board.length;
        boolean checkColumnBound = 0 <= column && column < board[0].length;
        if(!checkRowBound | !checkColumnBound){
            return false;
        }
        String position = row + "," + column;
        if(visitedPosition.contains(position)){
            return false;
        }
        if(board[row][column] != word.charAt(charPosition)){
            return false;
        }

        if(charPosition == word.length() - 1){
            return true;
        }

        visitedPosition.add(position);
        charPosition++;
        boolean charFound = traversal_DFS(board, row - 1, column, visitedPosition, word, charPosition) ||
                                traversal_DFS(board, row + 1, column, visitedPosition, word, charPosition) ||
                                traversal_DFS(board, row , column - 1, visitedPosition, word, charPosition) ||
                                traversal_DFS(board, row, column + 1, visitedPosition, word, charPosition);
        visitedPosition.remove(position);
        return charFound;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
