package data_structures;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MyStackTest {

    private MyStack<Integer> integerMyStack;

    @Before
    public void setup() {
        integerMyStack = new MyStack<>();
    }

    @Test(expected = Exception.class)
    public void testPopOnEmpty() {
        integerMyStack.pop();
    }

    @Test(expected = Exception.class)
    public void testPeekOnEmpty() {
        integerMyStack.peek();
    }

    @Test
    public void testPush() {
        integerMyStack.push(2);
        assertThat(integerMyStack.getSize(), is(1));
    }

    @Test
    public void testPeek() {
        integerMyStack.push(2);
        assertThat(integerMyStack.peek(), is(2));
        assertThat(integerMyStack.getSize(), is(1));

    }

    @Test
    public void testPop() {
        integerMyStack.push(2);
        assertThat(integerMyStack.pop(), is(2));
        assertThat(integerMyStack.getSize(), is(0));
    }

    @Test
    public void testExhaustively() {
        assertTrue(integerMyStack.isEmpty());
        integerMyStack.push(1);
        assertFalse(integerMyStack.isEmpty());
        integerMyStack.push(2);
        assertThat(integerMyStack.getSize(), is(2));
        assertThat(integerMyStack.peek(), is(2));
        assertThat(integerMyStack.getSize(), is(2));
        assertThat(integerMyStack.pop(), is(2));
        assertThat(integerMyStack.getSize(), is(1));
        assertThat(integerMyStack.peek(), is(1));
        assertThat(integerMyStack.getSize(), is(1));
        assertThat(integerMyStack.pop(), is(1));
        assertThat(integerMyStack.getSize(), is(0));
        assertTrue(integerMyStack.isEmpty());
    }

}