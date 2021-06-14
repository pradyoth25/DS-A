package leetcode_solved.karat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindShapes {

    public List<List<List<Integer>>> findShapes(int[][] matrix) {
        List<List<List<Integer>>> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    List<List<Integer>> temp = new ArrayList<>();
                    dfs(matrix, i, j, temp);
                    res.add(new ArrayList<>(temp));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, int i, int j, List<List<Integer>> temp) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 1)
            return;
        temp.add(new ArrayList<>(Arrays.asList(i, j)));
        matrix[i][j] = 1;
        dfs(matrix, i + 1, j, temp);
        dfs(matrix, i - 1, j, temp);
        dfs(matrix, i, j + 1, temp);
        dfs(matrix, i, j - 1, temp);
    }

}
