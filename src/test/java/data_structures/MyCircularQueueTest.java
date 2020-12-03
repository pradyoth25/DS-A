package data_structures;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MyCircularQueueTest {

    MyCircularQueue q = new MyCircularQueue(5);

    @Test
    public void testOperations() {
        assertTrue(q.isEmpty());
        assertThat(q.size, is(0));
        q.enqueue(1);
        assertFalse(q.isEmpty());
        assertThat(q.size, is(1));
        assertThat(q.peekFirst(), is(1));
        assertThat(q.peekLast(), is (1));
        assertThat(q.dequeue(), is(1));
        assertTrue(q.isEmpty());
    }

}