package problem_types;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JumpGamesTest {

    JumpGames jumpGames = new JumpGames();

    @Test
    public void testGames() {
        int[] arr = new int[]{4, 2, 3, 0, 3, 1, 2};
        int start = 5;

        assertThat(jumpGames.canJump(arr), is(true));
        assertThat(jumpGames.findMinimumJumpsToGetToEnd(arr), is(2));
        assertThat(jumpGames.canReachAnIndexWithZero(arr, start), is(true));
    }

}