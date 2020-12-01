package data_structures;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class SinglyLinkedListTest {

    SinglyLinkedList<Integer> list;

    @Before
    public void setup() {
        list = new SinglyLinkedList<>();
    }

    @Test
    public void testEmptyList() {
        assertThat(list.isEmpty(), is(true));
        assertThat(list.getSize(), is(0));
    }

    @Test
    public void testAddFirst() {
        list.addFirst(3);
        assertThat(list.getSize(), is(1));
        list.addFirst(5);
        assertThat(list.getSize(), is(2));
        assertThat(list.toString(), is("[5, 3]"));
    }

    @Test
    public void testAddLast() {
        list.add(3);
        assertThat(list.getSize(), is(1));
        list.add(5);
        assertThat(list.getSize(), is(2));
        assertThat(list.toString(), is("[3, 5]"));
    }

    @Test
    public void testAddAt() throws Exception {
        assertThat(list.getSize(), is(0));
        list.addAt(0, 0);
        assertThat(list.getSize(), is(1));
        list.addAt(1, 1);
        assertThat(list.getSize(), is(2));
        list.addAt(1, 2);
        assertThat(list.getSize(), is(3));
        list.addAt(2, 3);
        assertThat(list.getSize(), is(4));
        list.addAt(1, 8);
        assertThat(list.getSize(), is(5));
        assertThat(list.toString(), is("[0, 1, 1, 2, 1]"));
    }

    @Test
    public void testRemoveFirst() {
        list.addFirst(1);
        list.addFirst(3);
        assertThat(list.removeFirst(), is(3));
    }

    @Test
    public void testRemoveLast() {
        list.add(4);
        list.add(5);
        assertThat(list.removeLast(), is(5));
    }

    @Test
    public void testPeekFirst() {
        list.addFirst(4);
        assertThat(list.peekFirst(), is(4));
        assertFalse(list.isEmpty());
    }

}