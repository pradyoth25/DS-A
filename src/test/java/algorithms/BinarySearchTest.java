package algorithms;

import algorithms.binarySearch.BinarySearch;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BinarySearchTest {

    BinarySearch binarySearch = new BinarySearch();

    @Test
    public void testIndex() {
        int[] nums = new int[]{-101, -99, -54, -21, -3, 6, 12, 19, 20, 74, 92};
        assertThat(binarySearch.firstIndexOfNegativeNumber(nums), is(4));
    }

}