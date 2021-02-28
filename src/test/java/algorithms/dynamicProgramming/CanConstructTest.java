package algorithms.dynamicProgramming;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanConstructTest {

    Construct dp = new Construct();

    @Test
    public void canConstruct() {
        assertTrue(dp.naiveCanConstruct("abcdef", ImmutableList.<String>of("ab", "abc", "cd", "def", "abcd")));
        assertTrue(!dp.naiveCanConstruct("skateboard", ImmutableList.<String>of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        assertTrue(dp.realCanConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                ImmutableList.<String>of("ee", "eeee", "eeeeeeee", "e", "eeeeeeeeeeeee", "eeeeeeeeeeee")));
        assertTrue(dp.canConstructDP("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                ImmutableList.<String>of("ee", "eeee", "eeeeeeee", "e", "eeeeeeeeeeeee", "eeeeeeeeeeee")));
    }

    @Test
    public void countConstruct() {
        assertEquals(dp.countConstruct("abcdef", ImmutableList.<String>of("ab", "abc", "cd", "def", "abcd")), 1);
        assertEquals(dp.countConstruct("purple", ImmutableList.<String>of("purp", "p", "ur", "le", "purpl")), 2);
        assertEquals(dp.memoCountConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                ImmutableList.<String>of("ee", "eeee", "eeeeeeee", "e", "eeeeeeeeeeeee", "eeeeeeeeeeee")), 0);
        assertEquals(dp.countConstructDP("purple", ImmutableList.<String>of("purp", "p", "ur", "le", "purpl")), 2);
        assertEquals(dp.countConstructDP("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                ImmutableList.<String>of("ee", "eeee", "eeeeeeee", "e", "eeeeeeeeeeeee", "eeeeeeeeeeee")), 0);
    }

    @Test
    public void testAllConstruct() {
        assertEquals(dp.allConstruct("purple", ImmutableList.of("purp", "p", "ur", "le", "purpl")),
                ImmutableList.of(ImmutableList.of("purp", "le"), ImmutableList.of("p", "ur", "p", "le")));
        assertEquals(dp.realAllConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz", ImmutableList.of("a", "aa", "aaa", "aaaaa", "purpl")),
                ImmutableList.of());
    }

}