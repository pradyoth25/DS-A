package data_structures;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MyBSTTest {

    static final int LOOPS = 100;

    static List<Integer> genRandList(int sz) {
        List<Integer> lst = new ArrayList<>(sz);
        for (int i = 0; i < sz; i++) lst.add(i);
        Collections.shuffle(lst);
        return lst;
    }

    @Test
    public void testIsEmpty() {

        MyBST<String> tree = new MyBST<>();
        assertThat(tree.isEmpty(), is(true));

        tree.add("Hello World!");
        assertThat(tree.isEmpty(), is(false));
    }

    @Test
    public void testgetSize() {
        MyBST<String> tree = new MyBST<>();
        assertThat(tree.getSize(), is(0));

        tree.add("Hello World!");
        assertThat(tree.getSize(), is(1));
    }

    @Test
    public void testgetHeight() {
        MyBST<String> tree = new MyBST<>();

        // Tree should look like:
        //        M
        //      J  S
        //    B   N Z
        //  A

        // No tree
        assertThat(tree.getHeight(), is(0));

        // Layer One
        tree.add("M");
        assertThat(tree.getHeight(), is(1));

        // Layer Two
        tree.add("J");
        assertThat(tree.getHeight(), is(2));
        tree.add("S");
        assertThat(tree.getHeight(), is(2));

        // Layer Three
        tree.add("B");
        assertThat(tree.getHeight(), is(3));
        tree.add("N");
        assertThat(tree.getHeight(), is(3));
        tree.add("Z");
        assertThat(tree.getHeight(), is(3));

        // Layer 4
        tree.add("A");
        assertThat(tree.getHeight(), is(4));
    }

    @Test
    public void testAdd() {

        // Add element which does not yet exist
        MyBST<Character> tree = new MyBST<>();
        assertThat(tree.add('A'), is(true));

        // Add duplicate element
        assertThat(tree.add('A'), is(false));

        // Add a second element which is not a duplicate
        assertThat(tree.add('B'), is(true));
    }

    @Test
    public void testRemove() {

        // Try removing an element which doesn't exist
        MyBST<Character> tree = new MyBST<>();
        tree.add('A');
        assertThat(tree.getSize(), is(1));
        assertThat(tree.remove('B'), is(false));
        assertThat(tree.getSize(), is(1));

        // Try removing an element which does exist
        tree.add('B');
        assertThat(tree.getSize(), is(2));
        assertThat(tree.remove('B'), is(true));
        assertThat(tree.getSize(), is(1));
        assertThat(tree.getHeight(), is(1));

        // Try removing the root
        assertThat(tree.remove('A'), is(true));
        assertThat(tree.getSize(), is(0));
        assertThat(tree.getHeight(), is(0));
    }

    @Test
    public void testContains() {

        // Setup tree
        MyBST<Character> tree = new MyBST<>();

        tree.add('B');
        tree.add('A');
        tree.add('C');

        // Try looking for an element which doesn't exist
        assertThat(tree.contains('D'), is(false));

        // Try looking for an element which exists in the root
        assertThat(tree.contains('B'), is(true));

        // Try looking for an element which exists as the left child of the root
        assertThat(tree.contains('A'), is(true));

        // Try looking for an element which exists as the right child of the root
        assertThat(tree.contains('C'), is(true));
    }

    @Test
    public void randomRemoveTests() {

        for (int i = 0; i < LOOPS; i++) {

            int getSize = i;
            MyBST<Integer> tree = new MyBST<>();
            List<Integer> lst = genRandList(getSize);
            for (Integer value : lst) tree.add(value);

            Collections.shuffle(lst);
            // Remove all the elements we just placed in the tree
            for (int j = 0; j < getSize; j++) {

                Integer value = lst.get(j);

                assertThat(tree.remove(value), is(true));
                assertThat(tree.contains(value), is(false));
                assertThat(tree.getSize(), is(getSize - j - 1));
            }

            assertThat(tree.isEmpty(), is(true));
        }
    }

}