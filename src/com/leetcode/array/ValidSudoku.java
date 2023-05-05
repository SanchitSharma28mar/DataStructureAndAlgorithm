package com.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode: 36 (M)
 */
public class ValidSudoku {

    private static boolean isValidSudoku(char[][] board) {
        boolean validateRowColumn = validateRowColumn(board);
        System.out.println();
        boolean validateSubSquare = validateSubSquare(board);
        return validateRowColumn && validateSubSquare;
    }

    private static boolean validateRowColumn(char[][] board) {
        int numberOfRows = board.length;
        int numberOfColumns = board[0].length;

        Set<Character> rowSet = new HashSet<>();
        Set<Character> columnSet = new HashSet<>();
        for(int row = 0; row < numberOfRows; row++){
            for(int column = 0; column < numberOfColumns; column++){

                // Validate Row
                char rowChar = board[row][column];
                if(rowSet.contains(rowChar))
                    return false;
                if(rowChar != '.')
                    rowSet.add(rowChar);

                // Validate Column
                char columnChar = board[column][row];
                if(columnSet.contains(columnChar))
                    return false;
                if(columnChar != '.')
                    columnSet.add(columnChar);
            }
            columnSet.clear();
            rowSet.clear();
        }
        return true;
    }

    private static boolean validateSubSquare(char[][] board) {
        int rowMin = 0;
        int rowMax = 2;
        int columnMin = 0;
        int columnMax = 2;
        Set<Character> boxSet = new HashSet<>();
        for(int a = 0; a < 3; a++){
            for(int b = 0; b < 3; b++){

                for(int row = rowMin; row <= rowMax; row++){
                    for(int column = columnMin; column <= columnMax; column++){
                        char boxChar = board[row][column];
                        if(boxSet.contains(boxChar))
                            return false;
                        if(boxChar != '.')
                            boxSet.add(boxChar);
                    }
                }
                boxSet.clear();
                columnMin += 3;
                columnMax += 3;
            }
            rowMin += 3;
            rowMax += 3;
            columnMin = 0;
            columnMax = 2;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, 
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, 
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, 
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, 
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, 
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean validSudoku = isValidSudoku(board);
        System.out.println("Is Sudoku Valid = " + validSudoku);
    }
}
