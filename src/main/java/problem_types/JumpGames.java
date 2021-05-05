package problem_types;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGames {

    /**
     * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Determine if you are able to reach the last index.
     */
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i > farthest) return false;
            farthest = Math.max(farthest, nums[i] + i);
        }
        return true;
    }

    /**
     * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Your goal is to reach the last index in the minimum number of jumps.
     * You can assume that you can always reach the last index.
     */
    public int findMinimumJumpsToGetToEnd(int[] nums) {
        int jumps = 0, currJumpEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currJumpEnd) {
                jumps ++;
                currJumpEnd = farthest;
            }
        }
        return jumps;
    }

    /**
     * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
     * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
     */
    public boolean canReachAnIndexWithZero(int[] nums, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int currIndex = q.remove();
            if (nums[currIndex] == 0) return true;
            if (nums[currIndex] < 0) continue;
            if (currIndex + nums[currIndex] < nums.length) q.offer(currIndex + nums[currIndex]);
            if (currIndex - nums[currIndex] >= 0) q.offer(currIndex - nums[currIndex]);
            nums[currIndex] = -nums[currIndex];
        }
        return false;
    }

}
