package leetcode_solved.karat;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidMatrixTest {

    ValidMatrix code = new ValidMatrix();

    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 1}
        };
        int[][] rows = new int[][]{
                {}, {1}, {1, 2}, {1}, {2}
        };
        int[][] cols = new int[][]{
                {2, 1}, {1}, {2}, {1}
        };
        assertTrue(code.isValidNonogram(matrix, rows, cols));
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][]{
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 1}
        };
        int[][] rows = new int[][]{
                {}, {}, {1}, {1}, {1, 1}
        };
        int[][] cols = new int[][]{
                {2}, {1}, {2}, {1}
        };
        assertFalse(code.isValidNonogram(matrix, rows, cols));
    }

    @Test
    public void test3() {
        int[][] matrix = new int[][]{
                {1, 1},
                {0, 0},
                {0, 0},
                {1, 0}
        };
        int[][] rows = new int[][]{
                {}, {2}, {2}, {1}
        };
        int[][] cols = new int[][]{
                {1, 1}, {3}
        };
        assertFalse(code.isValidNonogram(matrix, rows, cols));
    }

}