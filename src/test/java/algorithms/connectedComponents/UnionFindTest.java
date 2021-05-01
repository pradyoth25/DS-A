package algorithms.connectedComponents;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UnionFindTest {

    @Test
    public void test() {
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        UnionFind unionFind = new UnionFind();
        assertThat(unionFind.connectedComponents(edges, 5), is(2));
    }

}