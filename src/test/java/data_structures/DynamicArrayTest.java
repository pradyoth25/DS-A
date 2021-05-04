package data_structures;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DynamicArrayTest {

    @Test
    public void testIntegerArray() {
        DynamicArray<Integer> array = new DynamicArray<Integer>(2);
        assertThat(array.size(), is(0));
        array.add(1);
        array.add(2);
        assertThat(array.toString(), is("[1, 2]"));
        array.add(3);
    }

    @Test
    public void test() {
        List<List<String>> logs = new ArrayList<>();
        logs.add(Arrays.asList("58523", "user_1", "resource_1"));
        logs.add(Arrays.asList("62314", "user_2", "resource_2"));
        logs.add(Arrays.asList("54001", "user_1", "resource_3"));
        logs.add(Arrays.asList("200", "user_6", "resource_5"));
        logs.add(Arrays.asList("215", "user_6", "resource_4"));
        logs.add(Arrays.asList("54060", "user_2", "resource_3"));
        logs.add(Arrays.asList("53760", "user_3", "resource_3"));
        logs.add(Arrays.asList("58522", "user_22", "resource_1"));
        logs.add(Arrays.asList("53651", "user_5", "resource_3"));
        logs.add(Arrays.asList("2", "user_6", "resource_1"));
        logs.add(Arrays.asList("100", "user_6", "resource_6"));
        logs.add(Arrays.asList("400", "user_7", "resource_2"));
        logs.add(Arrays.asList("100", "user_8", "resource_6"));
        logs.add(Arrays.asList("54359", "user_1", "resource_3"));
        mostAccess(logs, 300);

    }
    private void mostAccess(List<List<String>> logs, int window) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (List<String> log : logs) {
            int ts = Integer.parseInt(log.get(0));
            String user = log.get(1);
            String resource = log.get(2);
            map.putIfAbsent(resource, new ArrayList<>());
            map.get(resource).add(ts);
        }
        String resource = null;
        int max = 0;
        List<Integer> mT = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
            List<Integer> timestamps = e.getValue();
            Collections.sort(timestamps);
            if (resource == null) {
                resource = e.getKey(); max = 1;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(timestamps.get(0));
            for (int i = 1; i < timestamps.size(); i ++) {
                int currTime = timestamps.get(i);
                while (!temp.isEmpty() && currTime - temp.get(0) > window) {
                    temp.remove(0);
                }
                temp.add(currTime);
                if (temp.size() > max) {
                    max = temp.size();
                    resource = e.getKey();
                    mT = new ArrayList<>(temp);
                }
            }
        }
        System.out.println(max);
        System.out.println(resource);
        System.out.println(mT);
    }

}