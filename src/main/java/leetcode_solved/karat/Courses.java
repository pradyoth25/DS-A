package leetcode_solved.karat;


import java.util.*;

public class Courses {

    public List<String> courses(String[][] pairs) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            map.putIfAbsent(pair[0], new HashSet<>());
            map.get(pair[0]).add(pair[1]);
        }
        List<String> res = new ArrayList<>();
        for (String s1 : map.keySet()) {
            Set<String> s1Courses = map.get(s1);
            for (String s2 : map.keySet()) {
                if (s1.equals(s2)) continue;
                StringBuilder sb = new StringBuilder();
                sb.append("[").append(s1).append(", ").append(s2).append("]").append("->[");
                for (String course : map.get(s2)) {
                    if (s1Courses.contains(course)) sb.append(course).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append("]");
                res.add(sb.toString());
            }
        }
        return res;
    }

    public List<String> middleCourses(String[][] input) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> seen = new HashSet<>();
        for (String[] p : input) {
            seen.add(p[0]); seen.add(p[1]);
        }
        for (String course : seen) {
            map.put(course, 0);
        }
        for (String[] p : input) {
            // prereq, course
            String prereq = p[0], course = p[1];
            map.put(course, map.get(course) + 1);
        }
        Queue<String> q = new LinkedList<>();
        List<String> res = new ArrayList<>();
        for (String course : map.keySet()) {
            if (map.get(course) == 0) {
                res = new ArrayList<>();
                q.offer(course);
                coursesForOnePath(input, map, q, res);
                System.out.println(res);
            }
        }

        return res;
    }

    private void coursesForOnePath(String[][] input, Map<String, Integer> map, Queue<String> q, List<String> res) {
        while (!q.isEmpty()) {
            String curr = q.remove();
            res.add(curr);
            for (String[] p : input) {
                if (p[0].equals(curr)) {
                    map.put(p[1], map.get(p[1]) - 1);
                    if (map.get(p[1]) == 0) q.offer(p[1]);
                }
            }
        }
    }

}
