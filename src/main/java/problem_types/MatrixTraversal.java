package problem_types;

import java.util.ArrayList;
import java.util.List;

public class MatrixTraversal {

    public void printSecondaryDiagonalOrder(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int maxSum = r + c - 2;
        for (int sum = 0; sum <= maxSum; sum ++) {
            for (int i = 0; i < r; i ++) {
                for (int j = 0; j < c; j ++) {
                    if (i + j - sum == 0) System.out.print(matrix[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public void printReverse(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int maxSum = r + c - 2;
        for (int sum = maxSum; sum >= 0; sum --) {
            for (int i = 0; i < r; i ++) {
                for (int j = 0; j < c; j ++) {
                    if (i + j - sum == 0) System.out.print(matrix[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public List<Integer> diagonalTraverse(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int r = 0, c = 0;
        for (int i = 0; i < m * n; i ++) {
            res.add(matrix[r][c]);
            if ((r + c) % 2 == 0) {
                // Going up
                if (c == n - 1) r ++;
                else if (r == 0) c ++;
                else {r --; c ++;}
            } else {
                // Going down
                if (r == m - 1) c ++;
                else if (c == 0) r ++;
                else {r ++; c --;}
            }
        }
        return res;
    }

    public void rotateClockwise(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < i; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < m / 2; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - j - 1];
                matrix[i][m - j - 1] = temp;
            }
        }
    }

    public void rotateAntiClockWise(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < i; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n / 2; i ++) {
            for (int j = 0; j < n; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
    }


}
