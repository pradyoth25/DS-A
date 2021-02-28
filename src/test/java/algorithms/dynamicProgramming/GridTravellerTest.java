package algorithms.dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridTravellerTest {

    GridTraveller dp = new GridTraveller();

    @Test
    public void testGridTraveller() {
        assertEquals(dp.gridTravellerDP(1, 1), 1);
        assertEquals(dp.gridTravellerDP(3, 2), 3);
        assertEquals(dp.gridTravellerDP(10, 10), 48620);
    }

}