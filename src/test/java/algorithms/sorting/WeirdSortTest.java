package algorithms.sorting;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WeirdSortTest {

    WeirdSort weirdSort = new WeirdSort();

    @Test
    public void test() {
        int[] arr = new int[]{0,1,2,2,1,0,0,2,0,1,1,0};
        weirdSort.dutchNationalFlagSort(arr);
        assertEquals(Arrays.toString(arr), ImmutableList.of(0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2).toString());
    }

}