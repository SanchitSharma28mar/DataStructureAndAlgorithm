package com.leetcode.matrix;

/**
 * LeetCode: 74 (M)
 * ---
 *  Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 *  Output: false
 * ---
 *
 */
public class SearchElement {

    private static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;

        int numOfRows = matrix.length;
        int columns = matrix[0].length;

        int low = 0;
        int high = numOfRows * columns;
        while(low < high){
            int mid = (low + high)/2;
            int row = mid / columns;
            int column = mid % columns;
            if(matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 3));
    }
}
