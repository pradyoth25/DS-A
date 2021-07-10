package data_structures.scratch;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Scratch3Test {

    Scratch3 code = new Scratch3();

    @Test
    public void testSort() {
        int[] nums = new int[]{4,1,2,8,6,3,0};
        int[] nums2 = new int[]{4,1,2,8,6,3,0};
        code.mergeSort(nums);
        code.quickSort(nums2, 0, nums2.length - 1);
        assertEquals(Arrays.toString(nums), ImmutableList.of(0,1,2,3,4,6,8).toString());
        assertEquals(Arrays.toString(nums2), ImmutableList.of(0,1,2,3,4,6,8).toString());
    }

}