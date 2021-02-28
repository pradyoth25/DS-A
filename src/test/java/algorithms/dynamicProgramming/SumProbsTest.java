package algorithms.dynamicProgramming;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumProbsTest {

    SumProbs dp = new SumProbs();

    @Test
    public void testCanSum() {
        assertTrue(dp.naiveCanSum(new int[]{3, 4, 5, 7}, 7));
        assertFalse(dp.naiveCanSum(new int[]{3, 4, 5, 7}, 1));
        assertTrue(dp.naiveCanSum(new int[]{3, 4, 5, 7}, 3));
        assertTrue(dp.realCanSum(new int[]{100, 101, 200, 25, 33, 66, 77, 1023}, 126));
        assertTrue(dp.canSumDP(new int[]{100, 101, 200, 25, 33, 66, 77, 1023}, 126));
    }

    @Test
    public void testHowSum() {
        assertEquals(dp.naiveHowSum(new int[]{5, 3, 4, 7}, 7), ImmutableList.<Integer>of(3, 4));
        assertEquals(dp.naiveHowSum(new int[]{2, 3, 5}, 8), ImmutableList.<Integer>of(2,2,2,2));
        assertEquals(dp.naiveHowSum(new int[]{1, 4, 5}, 8), ImmutableList.<Integer>of(1, 1, 1, 1, 1, 1, 1, 1));
        assertEquals(dp.realHowSum(new int[]{1, 2, 5, 25}, 100), ImmutableList.<Integer>of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        assertEquals(dp.howSumDP(new int[]{1, 2, 5, 25}, 100),
                ImmutableList.<Integer>of(25, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));    }

    @Test
    public void testBestSum() {
        assertEquals(dp.naiveBestSum(new int[]{5, 3, 4, 7}, 7), ImmutableList.<Integer>of(7));
        assertEquals(dp.naiveBestSum(new int[]{2, 3, 5}, 8), ImmutableList.<Integer>of(3, 5));
        assertEquals(dp.naiveBestSum(new int[]{1, 4, 5}, 8), ImmutableList.<Integer>of(4, 4));
        assertEquals(dp.realBestSum(new int[]{1, 2, 5, 25}, 100), ImmutableList.<Integer>of(25, 25, 25, 25));
        assertEquals(dp.bestSumDP(new int[]{1, 2, 5, 25}, 100), ImmutableList.<Integer>of(25, 25, 25, 25));
    }

}