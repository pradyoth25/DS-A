package leetcode_solved.karat;


import java.util.*;

public class Courses {

    public List<String> courses(String[][] pairs) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            map.putIfAbsent(pair[0], new HashSet<>());
            map.get(pair[0]).add(pair[1]);
        }
//        System.out.println(map);
        List<String> res = new ArrayList<>();
        for (String s1 : map.keySet()) {
            Set<String> s1Courses = map.get(s1);
            for (String s2 : map.keySet()) {
                if (s1.equals(s2)) continue;
                StringBuilder sb = new StringBuilder();
                sb.append(s1).append(", ").append(s2).append(" : ");
                for (String course : map.get(s2)) {
                    if (s1Courses.contains(course)) sb.append(course).append(" ,");
                }
                res.add(sb.toString());
            }
        }
        return res;
    }

}
