package leetcode_solved.karat;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class KScratchTest {

    KScratch code = new KScratch();

    @Test
    public void test() {
        String[] input1 = new String[]{"3234.html", "3235.html", "123.html" ,"xys.html", "t.html", "7hsaa.html", "sadasd.html"};
        String[] input2 = new String[]{"3234.html", "sdhsfjdsh.html", "123.html", "xys.html", "t.html", "7hsaa.html", "sadasd.html", "asdasd.html"};
        System.out.println(code.lcs(input1, input2));
    }

    @Test
    public void findShapes() {
        int[][] image = new int[][]{
                {1, 0, 0, 1, 1, 1, 1},
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

    @Test
    public void test2() {
        String[] input = new String[]{"1p3acres", "is", "a", "good", "place", "to", "communicate"};
        System.out.println(code.wordWrap(input, 12));
    }

    @Test
    public void testWrtap() {
        String[] input = new String[]{"123 45 67 8901234 5678", "12345 8 9 0 1 23"};
        String[] input2 = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        String[] input3 = new String[]{"123 45 67 8901234 5678", "12345 8 9 0 1 23"};
        int maxWidth = 10;
        List<String> res = code.wordWrap2(input, maxWidth);
        List<String> res2 = code.wordWrap2(input2, 16);
        System.out.println(res2);
        System.out.println(res);
        System.out.println(code.wordWrap2(input3, 15));

        /*

        [This----is----an, example--of-text, justification.--]
        [123--45-67, 8901234---, 5678-12345, 8-9-0-1-23]
        [123----45----67, 8901234----5678, 12345--8--9-0-1, 23-------------]
         */
    }

    @Test
    public void tesNonot() {
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
    public void tesNonot2() {
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
    public void tesNonot3() {
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

    @Test
    public void testSparse() {
        int n = 70000;
        KScratch.SparseVector A = new KScratch.SparseVector(n);
        KScratch.SparseVector B = new KScratch.SparseVector(n);
        A.set(3, 1.0);
        A.set(2500, 6.3);
        A.set(60000, 5.7);
        A.set(5000, 10.0);
        B.set(1, 7.5);
        B.set(3, 5.7);
        B.set(2500, -6.3);
        B.set(234, 12.0);
        System.out.println("A dot B = " + A.dotProduct(B));
        System.out.println("A  +  B   = " + A.plus(B));
    }

}