package algorithms.sorting;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {

    MergeSort mergeSort = new MergeSort();

    @Test
    public void test() {
        int[] nums = new int[]{4,1,2,8,6,3,0};
        mergeSort.mergeSort(nums);
        assertEquals(Arrays.toString(nums), ImmutableList.of(0,1,2,3,4,6,8).toString());
    }

}