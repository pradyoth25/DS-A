package data_structures;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class MyPriorityQueueTest {

    @Test
    public void testEmpty() {
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>();
        assertThat(pq.getSize(), is(0));
        assertThat(pq.isEmpty(), is(true));
        assertThat(pq.poll(), is(nullValue()));
        assertThat(pq.peek(), is(nullValue()));
    }

    @Test
    public void testHeapProperty() {
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>();
        Integer[] nums = {3, 2, 5, 6, 7, 9, 4, 8, 1};
        for (int i : nums) pq.add(i);
        for (int i = 1; i <= 9; i++) {
            assertThat(pq.poll(), is(i));
        }
        pq.clear();
        pq = new MyPriorityQueue<>(nums);
        for (int i = 1; i <= 9; i++) {
            assertThat(pq.poll(), is(i));
        }
    }

}