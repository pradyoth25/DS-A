package algorithms.sorting;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QuickSortTest {

    QuickSort quickSort = new QuickSort();

    @Test
    public void test() {
        int[] nums = new int[]{4,1,2,8,6,3,0};
        quickSort.quickSort(nums);
        assertEquals(Arrays.toString(nums), ImmutableList.of(0,1,2,3,4,6,8).toString());
    }


}