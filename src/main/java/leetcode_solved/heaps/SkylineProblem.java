package leetcode_solved.heaps;

import java.util.*;

public class SkylineProblem {

    public List<List<Integer>> getSkyLine(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(Arrays.asList(b[0], -b[2]));
            heights.add(Arrays.asList(b[1], b[2]));
        }
        heights.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0))) return a.get(0) - b.get(0);
            else return a.get(1) - b.get(1);
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(0);
        int prev = 0;
        for (List<Integer> h : heights) {
            if (h.get(1) < 0) pq.offer(-h.get(1));
            else pq.remove(h.get(1));
            int curr = pq.peek();
            if (prev != curr) {
                res.add(new ArrayList<>(Arrays.asList(h.get(0), curr)));
                prev = curr;
            }
        }
        return res;
    }

}
