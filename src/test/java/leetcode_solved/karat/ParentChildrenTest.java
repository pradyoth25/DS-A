package leetcode_solved.karat;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParentChildrenTest {

    ParentChildren code = new ParentChildren();

    @Test
    public void test() {
        int[][] pairs = new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 10}};
        System.out.println(code.commonAncestor1(pairs));
//        System.out.println(code.commonAncestor2(pairs, 3, 8));
//        System.out.println(code.commonAncestor2(pairs, 5, 8));
//        System.out.println(code.commonAncestor2(pairs, 6, 8));
//        System.out.println(code.commonAncestor2(pairs, 1, 3));

    }

}