package data_structures;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MyUnionFindTest {

    @Test
    public void testNumgetNumComponents() {
        MyUnionFind uf = new MyUnionFind(5);
        assertThat(uf.getNumComponents(), is(5));

        uf.unify(0, 1);
        assertThat(uf.getNumComponents(), is(4));

        uf.unify(1, 0);
        assertThat(uf.getNumComponents(), is(4));

        uf.unify(1, 2);
        assertThat(uf.getNumComponents(), is(3));

        uf.unify(0, 2);
        assertThat(uf.getNumComponents(), is(3));

        uf.unify(2, 1);
        assertThat(uf.getNumComponents(), is(3));

        uf.unify(3, 4);
        assertThat(uf.getNumComponents(), is(2));

        uf.unify(4, 3);
        assertThat(uf.getNumComponents(), is(2));

        uf.unify(1, 3);
        assertThat(uf.getNumComponents(), is(1));

        uf.unify(4, 0);
        assertThat(uf.getNumComponents(), is(1));
    }

    @Test
    public void testSize() {

        MyUnionFind uf = new MyUnionFind(5);
        assertThat(uf.size(), is(5));
        uf.unify(0, 1);
        uf.find(3);
        assertThat(uf.size(), is(5));
        uf.unify(1, 2);
        assertThat(uf.size(), is(5));
        uf.unify(0, 2);
        uf.find(1);
        assertThat(uf.size(), is(5));
        uf.unify(2, 1);
        assertThat(uf.size(), is(5));
        uf.unify(3, 4);
        uf.find(0);
        assertThat(uf.size(), is(5));
        uf.unify(4, 3);
        uf.find(3);
        assertThat(uf.size(), is(5));
        uf.unify(1, 3);
        assertThat(uf.size(), is(5));
        uf.find(2);
        uf.unify(4, 0);
        assertThat(uf.size(), is(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadMyUnionFindCreation1() {
        new MyUnionFind(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadMyUnionFindCreation2() {
        new MyUnionFind(-3463);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadMyUnionFindCreation3() {
        new MyUnionFind(0);
    }

}