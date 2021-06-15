package leetcode_solved.karat;

import java.util.*;

public class ParentChildren {

    public List<List<Integer>> commonAncestor1(int[][] pairs) {
        List<Integer> zero = new ArrayList<>(), ones = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : pairs) {
            int parent = pair[0], child = pair[1]; // parent, child
            map.put(child, map.getOrDefault(child, 0) + 1);
            map.put(parent, map.getOrDefault(parent, 0));
        }
        for (int node : map.keySet()) {
            if (map.get(node) == 0) zero.add(node);
            if (map.get(node) == 1) ones.add(node);
        }
        return new ArrayList<>(Arrays.asList(zero, ones));
    }

    public boolean commonAncestor2(int[][] pairs, int node1, int node2) {
        Set<Integer> p1 = new HashSet<>(), p2 = new HashSet<>();
        helper(p1, node1, pairs);
        helper(p2, node2, pairs);
        for (int parent : p1) {
            if (p2.contains(parent)) return true;
        }
        return false;
    }
    private void helper(Set<Integer> parents, int node, int[][] pairs) {
        for (int[] pair : pairs) {
            int parent = pair[0], child = pair[1]; // parent, child
            if (child == node) {
                parents.add(parent);
                helper(parents, parent, pairs);
            }
        }
    }

}
