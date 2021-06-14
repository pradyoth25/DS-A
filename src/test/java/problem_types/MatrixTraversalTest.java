package problem_types;

import org.junit.Test;

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

}