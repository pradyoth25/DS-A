package geeks_for_geeks.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BasicArrayOperationsTest {

    BasicArrayOperations code = new BasicArrayOperations();

    @Test
    public void test() {
        int[] arr = new int[]{1,5,2,6,7};
        code.reverse(arr);
        assertThat(Arrays.toString(arr), is("[7, 6, 2, 5, 1]"));
        assertThat(code.findMaxElement(arr), is(7));
        assertThat(code.findMinElement(arr), is(1));
        assertThat(code.findKthSmallestElement(arr, 3), is(5));
    }

    @Test
    public void dnfTest() {
        int[] arr = new int[]{0,1,2,0,1,2,0};
        code.dutchNationalFlagSort(arr);
        assertThat(Arrays.toString(arr), is("[0, 0, 0, 1, 1, 2, 2]"));
        int[] arr2 = new int[]{0,1,2,0,1,2,0,2,2,1};
        code.dutchNationalFlagSort(arr2);
        assertThat(Arrays.toString(arr2), is("[0, 0, 0, 1, 1, 1, 2, 2, 2, 2]"));
    }

    @Test
    public void testShiftNumsToLeft() {
        int[] nums = new int[]{-12, 11, -13, -5, 6, -7, 5, -3, 11 };
        code.shiftAllNegativeElementsToLeft(nums);
        assertThat(Arrays.toString(nums), is("[-12, -3, -13, -5, -7, 6, 5, 11, 11]"));
    }

}