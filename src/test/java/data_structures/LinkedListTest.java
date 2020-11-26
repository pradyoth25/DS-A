package data_structures;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LinkedListTest {

    private static final int LOOPS = 10000;
    private static final int TEST_SZ = 40;
    private static final int NUM_NULLS = TEST_SZ / 5;
    private static final int MAX_RAND_NUM = 250;

    LinkedList<Integer> list;

    // Generate a list of random numbers
    static List<Integer> genRandList(int sz) {
        List<Integer> lst = new ArrayList<>(sz);
        for (int i = 0; i < sz; i++) lst.add((int) (Math.random() * MAX_RAND_NUM));
        for (int i = 0; i < NUM_NULLS; i++) lst.add(null);
        Collections.shuffle(lst);
        return lst;
    }

    // Generate a list of unique random numbers
    static List<Integer> genUniqueRandList(int sz) {
        List<Integer> lst = new ArrayList<>(sz);
        for (int i = 0; i < sz; i++) lst.add(i);
        for (int i = 0; i < NUM_NULLS; i++) lst.add(null);
        Collections.shuffle(lst);
        return lst;
    }

    @Before
    public void setup() {
        list = new LinkedList<>();
    }

    @Test
    public void testEmptyList() {
        assertThat(list.isEmpty(), is(true));
        assertThat(list.getSize(), is(0));
    }

    @Test(expected = Exception.class)
    public void testRemoveFirstOfEmpty() {
        list.removeFirst();
    }

    @Test(expected = Exception.class)
    public void testRemoveLastOfEmpty() {
        list.removeLast();
    }

    @Test(expected = Exception.class)
    public void testPeekFirstOfEmpty() {
        list.peekFirst();
    }

    @Test(expected = Exception.class)
    public void testPeekLastOfEmpty() {
        list.peekLast();
    }

    @Test
    public void testAddFirst() {
        list.addFirst(3);
        assertThat(list.getSize(), is(1));
        list.addFirst(5);
        assertThat(list.getSize(), is(2));
    }

    @Test
    public void testAddLast() {
        list.addLast(3);
        assertThat(list.getSize(), is(1));
        list.addLast(5);
        assertThat(list.getSize(), is(2));
    }

    @Test
    public void testAddAt() throws Exception {
        list.addAt(0, 1);
        assertThat(list.getSize(), is(1));
        list.addAt(1, 2);
        assertThat(list.getSize(), is(2));
        list.addAt(1, 3);
        assertThat(list.getSize(), is(3));
        list.addAt(2, 4);
        assertThat(list.getSize(), is(4));
        list.addAt(1, 8);
        assertThat(list.getSize(), is(5));
    }

    @Test
    public void testRemoveFirst() {
        list.addFirst(3);
        assertThat(list.removeFirst(), is(3));
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveLast() {
        list.addLast(4);
        assertThat(list.removeFirst(), is(4));
        assertTrue(list.isEmpty());
    }

    @Test
    public void testPeekFirst() {
        list.addFirst(4);
        assertThat(list.peekFirst(), is(4));
        assertFalse(list.isEmpty());
    }

    @Test
    public void testPeekLast() {
        list.addLast(4);
        assertThat(list.peekLast(), is(4));
        assertFalse(list.isEmpty());
    }

    @Test
    public void testPeeking() {
        // 5
        list.addFirst(5);
        assertThat(list.peekFirst(), is(5));
        assertThat(list.peekLast(), is(5));

        // 6 - 5
        list.addFirst(6);
        assertThat(list.peekFirst(), is(6));
        assertThat(list.peekLast(), is(5));

        // 7 - 6 - 5
        list.addFirst(7);
        assertThat(list.peekFirst(), is(7));
        assertThat(list.peekLast(), is(5));

        // 7 - 6 - 5 - 8
        list.addLast(8);
        assertThat(list.peekFirst(), is(7));
        assertThat(list.peekLast(), is(8));

        // 7 - 6 - 5
        list.removeLast();
        assertThat(list.peekFirst(), is(7));
        assertThat(list.peekLast(), is(5));

        // 7 - 6
        list.removeLast();
        assertThat(list.peekFirst(), is(7));
        assertThat(list.peekLast(), is(6));

        // 6
        list.removeFirst();
        assertThat(list.peekFirst(), is(6));
        assertThat(list.peekLast(), is(6));
    }

    @Test
    public void testRemoving() {
        LinkedList<String> strs = new LinkedList<>();
        strs.add("a");
        strs.add("b");
        strs.add("c");
        strs.add("d");
        strs.add("e");
        strs.add("f");
        strs.remove("b");
        strs.remove("a");
        strs.remove("d");
        strs.remove("e");
        strs.remove("c");
        strs.remove("f");
        assertThat(strs.getSize(), is(0));
    }

    @Test
    public void testRemoveAt() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.removeAt(0);
        list.removeAt(2);
        assertThat(list.peekFirst(), is(2));
        assertThat(list.peekLast(), is(3));
        list.removeAt(1);
        list.removeAt(0);
        assertThat(list.getSize(), is(0));
    }

    @Test
    public void testClear() {
        list.add(22);
        list.add(33);
        list.add(44);
        assertThat(list.getSize(), is(3));
        list.clear();
        assertThat(list.getSize(), is(0));
        list.add(22);
        list.add(33);
        list.add(44);
        assertThat(list.getSize(), is(3));
        list.clear();
        assertThat(list.getSize(), is(0));
    }

    @Test
    public void testToString() {
        LinkedList<String> strs = new LinkedList<>();
        assertThat(strs.toString(), is("[  ]"));
        strs.add("a");
        assertThat(strs.toString(), is("[ a ]"));
        strs.add("b");
        assertThat(strs.toString(), is("[ a, b ]"));
        strs.add("c");
        strs.add("d");
        strs.add("e");
        strs.add("f");
        assertThat(strs.toString(), is("[ a, b, c, d, e, f ]"));
    }

//    @Test
//    public void testIntegerList() throws Exception {
//        LinkedList<Integer> list = new LinkedList<Integer>();
//        assertThat(list.isEmpty(), is(true));
//        list.add(4);
//        assertThat(list.getSize(), is(1));
//        list.add(2);
//        list.addAt(1, 5);
//        assertThat(list.toString(), is("[4, 5, 2]"));
//    }

}