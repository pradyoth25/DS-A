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

//
//import java.io.*;
//        import java.util.*;
//
///*
//Write a function that takes the logs as input, builds the transition graph and returns it as an adjacency list with probabilities. Add __START__ and __END__ states.
//
//
//Example:
//logs1 = [
//    ["58523", "user_1", "resource_1"],
//    ["62314", "user_2", "resource_2"],
//    ["54001", "user_1", "resource_3"],
//    ["200", "user_6", "resource_5"],
//    ["215", "user_6", "resource_4"],
//    ["54060", "user_2", "resource_3"],
//    ["53760", "user_3", "resource_3"],
//    ["58522", "user_22", "resource_1"],
//    ["53651", "user_5", "resource_3"],
//    ["2", "user_6", "resource_1"],
//    ["100", "user_6", "resource_6"],
//    ["400", "user_7", "resource_2"],
//    ["100", "user_8", "resource_6"],
//    ["54359", "user_1", "resource_3"],
//]
//
//Example 2:
//logs2 = [
//    ["300", "user_1", "resource_3"],
//    ["599", "user_1", "resource_3"],
//    ["900", "user_1", "resource_3"],
//    ["1199", "user_1", "resource_3"],
//    ["1200", "user_1", "resource_3"],
//    ["1201", "user_1", "resource_3"],
//    ["1202", "user_1", "resource_3"]
//]
//
//
//Specifically, for each resource, we want to compute a list of every possible next step taken by any user, together with the corresponding probabilities. The list of resources should include __START__ but not __END__, since by definition __END__ is a terminal state.
//
//Expected output for logs1:
//transition_graph(logs1) # =>
//{
//    '__START__': {'resource_1': 0.25, 'resource_2': 0.125, 'resource_3': 0.5, 'resource_6': 0.125},
//    'resource_1': {'resource_6': 0.333, '__END__': 0.667},
//    'resource_2': {'__END__': 1.0},
//    'resource_3': {'__END__': 0.4, 'resource_1': 0.2, 'resource_2': 0.2, 'resource_3': 0.2},
//    'resource_4': {'__END__': 1.0},
//    'resource_5': {'resource_4': 1.0},
//    'resource_6': {'__END__': 0.5, 'resource_5': 0.5}
//}
//
//
//For example, of 8 total users, 4 users have resource_3 as a first visit (user_1, user_2, user_3, user_5), 2 users have resource_1 as a first visit (user_6, user_22), 1 user has resource_2 as a first visit (user_7), and 1 user has resource_6 (user_8) so the possible next steps for __START__ are resource_3 with probability 4/8, resource_1 with probability 2/8, and resource_2 and resource_6 with probability 1/8.
//
//These are the resource paths per user for the first logs example, ordered by access time:
//{
//    'user_1': ['resource_3', 'resource_3', 'resource_1'],
//    'user_2': ['resource_3', 'resource_2'],
//    'user_3': ['resource_3'],
//    'user_5': ['resource_3'],
//    'user_6': ['resource_1', 'resource_6', 'resource_5', 'resource_4'],
//    'user_7': ['resource_2'],
//    'user_8': ['resource_6'],
//    'user_22': ['resource_1'],
//}
//
//Expected output for logs2:
//transition_graph(logs2) # =>
//{
//  '__START__': {'resource_3': 1.0},
//  'resource_3': {'resource_3: 0.857, '__END__': 0.143}
//}
//
//
//Complexity analysis variables:
//
//n: number of logs in the input
//
//*/
//
//public class Solution {
//
//    // input.length = N
//    // Number of resources = K
//    // Average number of tiemstamp
//    public static List<String> most_requested_resource(String[][] input) {
//        Map<String, List<Integer>> map = new HashMap<>();
//        for (String[] line : input) {
//            Integer timestamp = Integer.parseInt(line[0]);
//            String resource = line[2];
//            map.putIfAbsent(resource, new ArrayList<>());
//            map.get(resource).add(timestamp);
//        }
//        for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
//            Collections.sort(e.getValue());
//        }
////     System.out.println(map);
//        Map<String,List<Integer>> finalMap = new HashMap<>();
//        for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
//            List<Integer> temp = new ArrayList<>();
//            List<Integer> maxTimeForResource = new ArrayList<>();
//
//            List<Integer> timestamps = map.get(e.getKey());
//            int prev = timestamps.get(0), window = 300, maxSize = 0;
//            for (int i = 0; i < timestamps.size(); i ++) {
//                int currentTime = timestamps.get(i);
//                temp = new ArrayList<>();
//                for (int j = i; j < timestamps.size(); j ++) {
//                    if (timestamps.get(j) - currentTime <= 300) {
//                        temp.add(timestamps.get(j));
//                        if (maxTimeForResource.size() < temp.size()) {
//                            maxTimeForResource = new ArrayList<>(temp);
//                        }
//                    }
//                }
//            }
//            finalMap.put(e.getKey(), maxTimeForResource);
//        }
//        System.out.println(finalMap);
//        String resultResource = "";
//        int maxSize = 0;
//        for (Map.Entry<String, List<Integer>> e : finalMap.entrySet()) {
//            if (e.getValue().size() > maxSize) {
//                maxSize = e.getValue().size();
//                resultResource = e.getKey();
//            }
//        }
//        return new ArrayList<>(Arrays.asList(resultResource, (maxSize + "")));
//    }
//
//    public static List<String> transition_graph(String[][] input) {
//        // build graph first
//        // first probability : p(A) / n , P(B) / n ...
//        // resrouce 1: P(A) => all paths from here : P(B) / m and so on...
//        // resource n:
//        return new ArrayList<>();
//    }
//
//    public static void main(String[] argv) {
//        String[][] logs1 = new String[][] {
//                { "58523", "user_1", "resource_1" },
//                { "62314", "user_2", "resource_2" },
//                { "54001", "user_1", "resource_3" },
//                { "200", "user_6", "resource_5" },
//                { "215", "user_6", "resource_4" },
//                { "54060", "user_2", "resource_3" },
//                { "53760", "user_3", "resource_3" },
//                { "58522", "user_22", "resource_1" },
//                { "53651", "user_5", "resource_3" },
//                { "2", "user_6", "resource_1" },
//                { "100", "user_6", "resource_6" },
//                { "400", "user_7", "resource_2" },
//                { "100", "user_8", "resource_6" },
//                {"54359", "user_1", "resource_3"},
//        };
//
//        String[][] logs2 = new String[][] {
//                {"300", "user_1", "resource_3"},
//                {"599", "user_1", "resource_3"},
//                {"900", "user_1", "resource_3"},
//                {"1199", "user_1", "resource_3"},
//                {"1200", "user_1", "resource_3"},
//                {"1201", "user_1", "resource_3"},
//                {"1202", "user_1", "resource_3"}
//        };
//
//
//        System.out.println(most_requested_resource(logs2));
//    }
//}
