package leetcode_solved.karat;

import java.util.HashSet;
import java.util.Set;

public class ValidMatrix {

    /**
     * Given an N*N matrix, determine whether it is a valid matrix. The definition of an effective matrix is ​​that
     * the number in each row or column must be exactly a number from 1 to N. Output a bool.
     */
    public boolean isValidMatrix(int[][] matrix) {
        int m = matrix.length;
        for (int i = 0; i < m; i ++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            int rowMin = Integer.MAX_VALUE, rowMax = Integer.MIN_VALUE;
            int colMin = rowMin, colMax = rowMax;
            for (int j = 0; j < m; j ++) {
                if (!rowSet.contains(matrix[i][j])) {
                    rowSet.add(matrix[i][j]);
                    rowMin = Math.min(rowMin, matrix[i][j]); rowMax = Math.max(rowMax, matrix[i][j]);
                } else {
                    return false;
                }
                if (!colSet.contains(matrix[i][j])) {
                    colSet.add(matrix[i][j]);
                    colMin = Math.min(colMin, matrix[i][j]); colMax = Math.max(colMax, matrix[i][j]);
                } else {
                    return false;
                }
            }
            if (rowMin != 1 || colMin != 1 || rowMax != m || colMax != m) return false;
        }
        return true;
    }

    /**
     * """
     * A nonogram is a logic puzzle, similar to a crossword, in which the player is given a blank grid and has to color
     * it according to some instructions. Specifically, each cell can be either black or white, which we will represent
     * as 0 for black and 1 for white.
     *
     * +------------+
     * | 1  1  1  1 |
     * | 0  1  1  1 |
     * | 0  1  0  0 |
     * | 1  1  0  1 |
     * | 0  0  1  1 |
     * +------------+
     *
     * For each row and column, the instructions give the lengths of contiguous runs of black (0) cells. For example,
     * the instructions for one row of [ 2, 1 ] indicate that there must be a run of two black cells, followed later by
     * another run of one black cell, and the rest of the row filled with white cells.
     *
     * These are valid solutions: [ 1, 0, 0, 1, 0 ] and [ 0, 0, 1, 1, 0 ] and also [ 0, 0, 1, 0, 1 ]
     * This is not valid: [ 1, 0, 1, 0, 0 ] since the runs are not in the correct order.
     * This is not valid: [ 1, 0, 0, 0, 1 ] since the two runs of 0s are not separated by 1s.
     *
     * Your job is to write a function to validate a possible solution against a set of instructions. Given a 2D matrix
     * representing a player's solution; and instructions for each row along with additional instructions for each column;
     * return True or False according to whether both sets of instructions match.
     */
    public boolean isValidNonogram(int[][] matrix, int[][] rows, int[][] cols) {
        return isValidRows(matrix, rows) && isValidCols(matrix, cols);
    }

    private boolean isValidRows(int[][] matrix, int[][] rows) {
        for (int i = 0; i < matrix.length; i ++) {
            int[] currRow = rows[i];
            int count = 0, cIndex = 0;
            for (int j = 0; j < matrix[0].length; j ++) {
                if (matrix[i][j] == 0) {
                    if (currRow.length == 0) return false;
                    count ++;
                    if (count == currRow[cIndex]) {
                        if ((j == matrix[0].length - 1 || (j <= matrix[0].length - 2 && matrix[i][j + 1] == 1 ))) {
                            cIndex ++;
                            count = 0;
                        } else {
                            return false;
                        }
                    }
                }
            }
            if (cIndex < currRow.length) return false;
        }
        return true;
    }

    private boolean isValidCols(int[][] matrix, int[][] cols) {
        for (int j = 0; j < matrix[0].length; j ++) {
            int[] currCol = cols[j];
            int count = 0, cIndex = 0;
            for (int i = 0; i < matrix.length; i ++) {
                if (matrix[i][j] == 0) {
                    if (currCol.length == 0) return false;
                    count ++;
                    if (count == currCol[cIndex]) {
                        if ((i == matrix.length - 1) || (i <= matrix.length - 2 && matrix[i + 1][j] == 1)) {
                            cIndex ++;
                            count = 0;
                        } else {
                            return false;
                        }
                    }
                }
            }
            if (cIndex < currCol.length) return false;
        }
        return true;
    }

}
