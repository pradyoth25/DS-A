package leetcode_solved.karat;

import java.util.*;

public class BadgeAccess {

    public List<List<String>> unusualAccess(List<List<String>> records) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (List<String> record : records) {
            map.putIfAbsent(record.get(0), new ArrayList<>());
            map.get(record.get(0)).add(Integer.parseInt(record.get(1)));
        }
        System.out.println(map);
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
            if (e.getValue().size() < 3) continue;
            List<Integer> times = e.getValue();
            Collections.sort(times);
            int maxInAnHour = 1;
            int curr = 0, prevTime = times.get(0);
            for (int val : times) {
                if (val <= prevTime + 100) {
                    curr ++;
                    maxInAnHour = Math.max(maxInAnHour, curr);
                } else {
                    curr = 1;
                    prevTime = val;
                }
            }
            if (maxInAnHour >= 3) {
                res.add(new ArrayList<>(Arrays.asList(e.getKey(), e.getValue().toString())));
            }
        }
        return res;
    }

}
