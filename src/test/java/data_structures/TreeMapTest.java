package data_structures;

import org.junit.Test;

import java.util.Set;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class TreeMapTest {

    @Test
    public void testTreeMap() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");

        Integer firstKey = map.firstKey();
        Integer lastKey = map.lastKey();
        Set<Integer> keysLessThan3 = map.headMap(3).keySet();
        Set<Integer> keysGreaterThanOrEqualTo3 = map.tailMap(3).keySet();

        assertEquals(java.util.Optional.of(5).get(), lastKey);
        assertEquals(java.util.Optional.of(1).get(), firstKey);
        assertEquals("[1, 2]", keysLessThan3.toString());
        assertEquals("[3, 4, 5]", keysGreaterThanOrEqualTo3.toString());
    }
}
