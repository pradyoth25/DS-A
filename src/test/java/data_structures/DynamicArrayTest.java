package data_structures;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DynamicArrayTest {

    @Test
    public void testIntegerArray() {
        DynamicArray<Integer> array = new DynamicArray<Integer>(2);
        assertThat(array.size(), is(0));
        array.add(1);
        array.add(2);
        assertThat(array.toString(), is("[1, 2]"));
        array.add(3);
    }

}