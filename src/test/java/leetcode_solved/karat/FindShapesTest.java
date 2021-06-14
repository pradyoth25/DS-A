package leetcode_solved.karat;

import org.junit.Test;

import java.util.List;

public class FindShapesTest {

    FindShapes code = new FindShapes();

    @Test
    public void test() {
        int[][] image = new int[][]{
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 1, 1},
                {0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {0, 1, 0, 1, 1, 1, 0},

        };
        List<List<List<Integer>>> res = code.findShapes(image);
        for (List<List<Integer>> r : res) {
            System.out.println(r);
        }
    }

}