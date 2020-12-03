package data_structures;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MyQueueTest {

    private MyQueue<Integer> integerMyQueue;

    @Before
    public void setup() {
        integerMyQueue = new MyQueue<>();
    }

    @Test(expected = Exception.class)
    public void testPopOnEmpty() {
        integerMyQueue.dequeue();
    }

    @Test(expected = Exception.class)
    public void testPeekOnEmpty() {
        integerMyQueue.peek();
    }

    @Test
    public void testPush() {
        integerMyQueue.enqueue(2);
        assertThat(integerMyQueue.getSize(), is(1));
    }

    @Test
    public void testPeek() {
        integerMyQueue.enqueue(2);
        assertThat(integerMyQueue.peek(), is(2));
        assertThat(integerMyQueue.getSize(), is(1));

    }

    @Test
    public void testPop() {
        integerMyQueue.enqueue(2);
        assertThat(integerMyQueue.dequeue(), is(2));
        assertThat(integerMyQueue.getSize(), is(0));
    }

    @Test
    public void testExhaustively() {
        assertTrue(integerMyQueue.isEmpty());
        integerMyQueue.enqueue(1);
        assertFalse(integerMyQueue.isEmpty());
        integerMyQueue.enqueue(2);
        assertThat(integerMyQueue.getSize(), is(2));
        assertThat(integerMyQueue.peek(), is(1));
        assertThat(integerMyQueue.getSize(), is(2));
        assertThat(integerMyQueue.dequeue(), is(1));
        assertThat(integerMyQueue.getSize(), is(1));
        assertThat(integerMyQueue.peek(), is(2));
        assertThat(integerMyQueue.getSize(), is(1));
        assertThat(integerMyQueue.dequeue(), is(2));
        assertThat(integerMyQueue.getSize(), is(0));
        assertTrue(integerMyQueue.isEmpty());
    }

}