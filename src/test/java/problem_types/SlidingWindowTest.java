package problem_types;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SlidingWindowTest {

    SlidingWindow slidingWindow = new SlidingWindow();

    @Test
    public void slidingWindowMaximum() {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        assertThat(slidingWindow.slidingWindowMaximum(nums, k), is(new int[]{3, 3, 5, 5, 6, 7}));
    }

    @Test
    public void slidingWindowMinimum() {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        assertThat(slidingWindow.slidingWindowMinimum(nums, k), is(new int[]{-1, -3, -3, -3, 3, 3}));
    }

}