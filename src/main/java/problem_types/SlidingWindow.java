package problem_types;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {

    public int[] slidingWindowMaximum(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) res[index++] = nums[dq.peekFirst()];
        }
        return res;
    }

    public int[] slidingWindowMinimum(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] > nums[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) res[index++] = nums[dq.peekFirst()];
        }
        return res;
    }

}
