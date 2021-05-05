package problem_types;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StonksTest {

    Stonks stonks = new Stonks();

    @Test
    public void test() {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        assertThat(stonks.maxProfitWithOneDayCoolDown(prices), is(3));
    }


}