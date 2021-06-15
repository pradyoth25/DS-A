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

    public List<String> frequentAccess(String[][] input) {
        List<String> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (String[] access : input) {
            map.putIfAbsent(access[0], new ArrayList<>());
            map.get(access[0]).add(getTime(access[1]));
        }
        for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
            Collections.sort(e.getValue());
            List<Integer> times = e.getValue();
            List<Integer> cTimes = new ArrayList<>();
            int prev = e.getValue().get(0);
            for (int time : times) {
                if (time - prev <= 60) {
                    cTimes.add(time);
                    if (cTimes.size() >= 3) res.add(e.getKey() + ":" + cTimes.toString());
                } else {
                    prev = time;
                    cTimes = new ArrayList<>();
                }
            }
        }

        return res;
    }
    private int getTime(String time) {
        int minutes;
        int hours;
        if (time.length() == 3) {
            minutes = Integer.parseInt(time.substring(1));
            hours = time.charAt(0) - '0';
        } else {
            minutes = Integer.parseInt(time.substring(2));
            hours = Integer.parseInt(time.substring(0, 2));
        }
        return hours * 60 + minutes;
    }

}
