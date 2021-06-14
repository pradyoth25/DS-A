package leetcode_solved.karat;

import java.util.*;

public class ParentChildren {

    public List<List<Integer>> commonAncestor1(int[][] pairs) {
        List<Integer> zero = new ArrayList<>(), one = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.put(pair[1], map.getOrDefault(pair[1], 0) + 1);
            map.put(pair[0], map.getOrDefault(pair[0], 0));
        }
        for (int node : map.keySet()) {
            if (map.get(node) == 0) zero.add(node);
            if (map.get(node) == 1) one.add(node);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(zero); res.add(one);
        return res;
    }

    public boolean commonAncestor2(int[][] pairs, int node1, int node2) {
        Set<Integer> p1 = new HashSet<>(), p2 = new HashSet<>();
        helper(p1, node1, pairs);
        helper(p2, node2, pairs);
        System.out.println("parents for " + node1 + " are " + p1);
        System.out.println("parents for " + node2 + " are " + p2);
        for (int parent : p1) {
            if (p2.contains(parent)) return true;
        }
        return false;
    }
    private void helper(Set<Integer> parents, int node, int[][] pairs) {
        for (int[] pair : pairs) {
            if (pair[1] == node) { // if child is node, add parent and check on parent
                parents.add(pair[0]);
                helper(parents, pair[0], pairs);
            }
        }
    }

}
