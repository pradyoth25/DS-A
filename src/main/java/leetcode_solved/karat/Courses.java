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

//
///*
//
//import java.io.*;
//import java.util.*;
//
///*
//
//Students may decide to take different "tracks" or sequences of courses in the Computer Science curriculum. There may be more than one track that includes the same course, but each student follows a single linear track from a "root" node to a "leaf" node. In the graph below, their path always moves left to right.
//
//Write a function that takes a list of (source, destination) pairs, and returns the name of all of the courses that the students could be taking when they are halfway through their track of courses.
//Sample input 1:
//all_courses_1 = [
//    ["Logic", "COBOL"],
//    ["Data Structures", "Algorithms"],
//    ["Creative Writing", "Data Structures"],
//    ["Algorithms", "COBOL"],
//    ["Intro to Computer Science", "Data Structures"],
//    ["Logic", "Compilers"],
//    ["Data Structures", "Logic"],
//    ["Graphics", "Networking"],
//    ["Networking", "Algorithms"],
//    ["Creative Writing", "System Administration"],
//    ["Databases", "System Administration"],
//    ["Creative Writing", "Databases"],
//    ["Intro to Computer Science", "Graphics"],
//]
//
//Sample output 1 (in any order):
//          ["Data Structures", "Networking", "Creative Writing", "Databases"]
//
//All paths through the curriculum (midpoint *highlighted*):
//
//Intro to C.S. -> Graphics -> *Networking* -> Algorithms -> Cobol
//Intro to C.S. -> *Data Structures* -> Algorithms -> COBOL
//Intro to C.S. -> *Data Structures* -> Logic -> COBOL
//Intro to C.S. -> *Data Structures* -> Logic -> Compiler
//Creative Writing -> *Databases* -> System Administration
//*Creative Writing* -> System Administration
//Creative Writing -> *Data Structures* -> Algorithms -> COBOL
//Creative Writing -> *Data Structures* -> Logic -> COBOL
//Creative Writing -> *Data Structures* -> Logic -> Compilers
//
//Visual representation:
//
//                    ____________    ______________
//                    |          |    |            |
//                    | Graphics |    | Networking |
//               ---->|__________|--->|____________|
//               |                       |
//               |                       |
//               |                       |  ______________
//____________   |                       |  |            |
//|          |   |    ______________     >->| Algorithms |--\     _____________
//| Intro to |   |    |            |    /   |____________|   \    |           |
//| C.S.     |---+    | Data       |   /                      >-->| COBOL     |
//|__________|    \   | Structures |--+     ______________   /    |___________|
//                 >->|____________|   \    |            |  /
//____________    /                     \-->| Logic      |-+      _____________
//|          |   /    ______________        |____________|  \     |           |
//| Creative |  /     |            |                         \--->| Compilers |
//| Writing  |-+----->| Databases  |                              |___________|
//|__________|  \     |____________|-\     _________________________
//               \                    \    |                       |
//                \--------------------+-->| System Administration |
//                                         |_______________________|
//
//Sample input 2:
//all_courses_2 = [
//    ["Course_3", "Course_7"],
//    ["Course_0", "Course_1"],
//    ["Course_1", "Course_2"],
//    ["Course_2", "Course_3"],
//    ["Course_3", "Course_4"],
//    ["Course_4", "Course_5"],
//    ["Course_5", "Course_6"],
//]
//Sample output 2 (in any order):
//["Course_2", "Course_3"]
//
//Complexity analysis variables:
//
//n: number of pairs in the input
//
//
//
//*/
//
//public class Solution {
//
//    private static List<String> findCommonCourses(String[][] input) {
//        if (input == null || input.length == 0) return new ArrayList<>();
//        Map<String, Set<String>> studentToCourses = new HashMap<>();
//
//        for (String[] student : input) {
//            String id = student[0], course = student[1];
//            studentToCourses.putIfAbsent(id, new HashSet<>());
//            studentToCourses.get(id).add(course);
//        }
//        List<String> result = new ArrayList<>();
//        Set<String> seenStudents = new HashSet<>();
//        for (String s1 : studentToCourses.keySet()) {
//            Set<String> s1Courses = studentToCourses.get(s1);
//            for (String s2 : studentToCourses.keySet()) {
//                if (s1.equals(s2)) continue;
//                StringBuilder sb = new StringBuilder();
//                for (String course : studentToCourses.get(s2)) {
//                    if (s1Courses.contains(course)) {
//                        sb.append(course).append(",");
//                    }
//                }
//                if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
//                String students = s1 + ", " + s2;
//                String studentsRev = s2 + ", " + s1;
//                String commonCourses = sb.length() == 0 ? "[]" : "[" + sb.toString() + "]";
//                if (!seenStudents.contains(students) || !seenStudents.contains(studentsRev)) {
//                    result.add(students + commonCourses);
//                    seenStudents.add(students); seenStudents.add(studentsRev);
//                }
//
//            }
//        }
//        return result;
//    }
//
//    public static String findMiddleCourse(String[][] input) {
//        if (input == null || input.length == 0) return "";
//        Set<String> seen = new HashSet<>();
//        for (String[] pair : input) {
//            // [prereq, course]
//            String prereq = pair[0], course = pair[1];
//            seen.add(prereq); seen.add(course);
//        }
//        Map<String, Integer> inDegree = new HashMap<>();
//        for (String course : seen) {
//            inDegree.put(course, 0);
//        }
//        for (String[] pair : input) {
//            // [prereq, course]
//            String prereq = pair[0], course = pair[1];
//            inDegree.put(course, inDegree.get(course) + 1);
//        }
//        Queue<String> q = new LinkedList<>();
//        List<String> result = new ArrayList<>();
//        for (Map.Entry<String, Integer> e : inDegree.entrySet()) {
//            if (e.getValue() == 0) q.offer(e.getKey());
//        }
//        while (!q.isEmpty()) {
//            String curr = q.remove();
//            result.add(curr);
//            for (String[] pair : input) {
//                String prereq = pair[0], course = pair[1];
//                if (curr.equals(prereq)) {
//                    inDegree.put(course, inDegree.get(course) - 1);
//                    if (inDegree.get(course) == 0) q.offer(course);
//                }
//            }
//        }
//        if (result.size() % 2 != 0) {
//            return result.get(result.size() / 2);
//        } else {
//            return result.get((result.size() / 2) - 1);
//        }
//
//    }
//
//    public static List<String> findMiddleCourses(String[][] input) {
//        if (input == null || input.length == 0) return new ArrayList<>();
//        Map<String, List<String>> paths = new HashMap<>();
//        Set<String> seen = new HashSet<>();
//        for (String[] path : input) {
//            String source = path[0], dest = path[1];// source, destination
//            paths.putIfAbsent(source, new ArrayList<>());
//            paths.get(source).add(dest);
//            seen.add(source); seen.add(dest);
//        }
//        Map<String, Integer> inDegree = new HashMap<>();
//        for (String c : seen) {
//            inDegree.put(c, 0);
//        }
//        for (String[] pair : input) {
//            String source = pair[0], dest = pair[1];// source, destination
//            inDegree.put(dest, inDegree.get(dest) + 1);
//        }
//        List<String> starts = new ArrayList<>();
//        for (String course : inDegree.keySet()) {
//            if (inDegree.get(course) == 0) starts.add(course);
//        }
//
//        List<String> result = new ArrayList<>();
//        for (String start : starts) {
//            dfs(start, paths, new ArrayList<>(), result);
//        }
//        return result;
//
//    }
//
//    private static void dfs(String start, Map<String, List<String>> paths, List<String> temp, List<String> result) {
//        if (!paths.containsKey(start)) {
//            // add middle element
//            if (paths.size() % 2 != 0) {
//                result.add(temp.get(paths.size() / 2));
//            } else {
//                result.add(temp.get((paths.size() / 2) - 1));
//            }
//            return;
//        }
//        for (String next : paths.get(start)) {
//            temp.add(next);
//            dfs(next, paths, temp, result);
//            temp.remove(temp.size() - 1);
//        }
//    }
//
//    public static void main(String[] argv) {
//        String[][] allCourses1 = {
//                {"Logic", "COBOL"},
//                {"Data Structures", "Algorithms"},
//                {"Creative Writing", "Data Structures"},
//                {"Algorithms", "COBOL"},
//                {"Intro to Computer Science", "Data Structures"},
//                {"Logic", "Compilers"},
//                {"Data Structures", "Logic"},
//                {"Graphics", "Networking"},
//                {"Networking", "Algorithms"},
//                {"Creative Writing", "System Administration"},
//                {"Databases", "System Administration"},
//                {"Creative Writing", "Databases"},
//                {"Intro to Computer Science", "Graphics"},
//        };
//        String[][] allCourses2 = {
//                {"Course_3", "Course_7"},
//                {"Course_0", "Course_1"},
//                {"Course_1", "Course_2"},
//                {"Course_2", "Course_3"},
//                {"Course_3", "Course_4"},
//                {"Course_4", "Course_5"},
//                {"Course_5", "Course_6"},
//        };
//
//
//
////     System.out.println(findCommonCourses(studentCoursePairs3));
////     System.out.println(findMiddleCourse(prereqsCourses3));
//        System.out.println(findMiddleCourses(allCourses1));
//
//    }
//
//
//}
//
//