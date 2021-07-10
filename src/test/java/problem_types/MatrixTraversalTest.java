package problem_types;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MatrixTraversalTest {

    MatrixTraversal matrixTraversal = new MatrixTraversal();

    @Test
    public void test1a() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrixTraversal.printSecondaryDiagonalOrder(matrix);
        matrixTraversal.printReverse(matrix);
        System.out.println(matrixTraversal.diagonalTraverse(matrix));
    }

    @Test
    public void testClockWiseRotation() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrixTraversal.rotateClockwise(matrix);
        for (int[] m : matrix) System.out.println(Arrays.toString(m));
    }

    @Test
    public void testAntiClockWiseRotation() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrixTraversal.rotateAntiClockWise(matrix);
        for (int[] m : matrix) System.out.println(Arrays.toString(m));
    }

    @Test
    public void testAntiClockWiseRotation2() {
        int[][] matrix = new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        matrixTraversal.rotateAntiClockWise(matrix);
        for (int[] m : matrix) System.out.println(Arrays.toString(m));
    }

}