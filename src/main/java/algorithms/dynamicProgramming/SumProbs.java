package algorithms.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumProbs {

    /**
     * CAN SUM
     */

    public boolean naiveCanSum(int[] numbers, int target) {
        if (target < 0) return false;
        if (target == 0) return true;
        for (int num : numbers) {
            if (naiveCanSum(numbers, target - num)) return true;
        }
        return false;
    }

    public boolean realCanSum(int[] numbers, int target) {
        return canSumMemo(numbers, target, new HashMap<Integer, Boolean>());
    }

    private boolean canSumMemo(int[] numbers, int target, Map<Integer, Boolean> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target < 0) return false;
        if (target == 0) return true;
        for (int num : numbers) {
            if (canSumMemo(numbers, target - num, memo)) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return true;
    }

    public boolean canSumDP(int[] numbers, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i <= target; i ++) {
            if (dp[i]) {
                for (int num : numbers) if (i + num < dp.length) dp[i + num] = true;
            }
        }
        return dp[target];
    }

    /**
     * HOW SUM
     */
    public List<Integer> naiveHowSum(int[] numbers, int target) {
        if (target < 0) return null;
        if (target == 0) return new ArrayList<>();
        for (int num : numbers) {
            List<Integer> res = naiveHowSum(numbers, target - num);
            if (res != null) {
                res.add(0, num);
                return res;
            }
        }
        return null;
    }

    public List<Integer> realHowSum(int[] numbers, int target) {
        Map<Integer, List<Integer>> memo = new HashMap<>();
        return howSumMemo(numbers, target, memo);
    }

    private List<Integer> howSumMemo(int[] numbers, int target, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target < 0) return null;
        if (target == 0) return new ArrayList<>();
        for (int num : numbers) {
            List<Integer> res = howSumMemo(numbers, target - num, memo);
            if (res != null) {
                res.add(0, num);
                memo.put(target, res);
                return res;
            }
        }
        memo.put(target, null);
        return null;
    }

    public List<Integer> howSumDP(int[] numbers, int target) {
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        for (int i = 0; i < target; i ++) dp.add(null);
        for (int i = 0; i <= target; i ++) {
            for (int num : numbers) {
                int index = i + num;
                if (index > target || dp.get(i) == null) continue;
                List<Integer> temp = new ArrayList<>(dp.get(i));
                temp.add(0, num);
                if (index == target) return temp;
                dp.set(index, temp);
            }
        }
        return null;
    }

    /**
     * BEST SUM
     */

    // m - target sum; n = numbers.length
    // Time: O(n^m * m)
    // Space: O(m^2)
    public List<Integer> naiveBestSum(int[] numbers, int target) {
        if (target < 0) return null;
        if (target == 0) return new ArrayList<>();
        List<Integer> shortest = null;
        for (int num : numbers) {
            List<Integer> res = naiveBestSum(numbers, target - num);
            if (res != null) {
                res.add(0, num);
                if (shortest == null || res.size() < shortest.size()) shortest = res;
            }
        }
        return shortest;
    }

    public List<Integer> realBestSum(int[] numbers, int target) {
        return bestSumMemo(numbers, target, new HashMap<Integer, List<Integer>>());
    }

    private List<Integer> bestSumMemo(int[] numbers, int target, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target < 0) return null;
        if (target == 0) return new ArrayList<>();
        List<Integer> shortest = null;
        for (int num : numbers) {
            List<Integer> res = bestSumMemo(numbers, target - num, memo);
            if (res != null) {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                list.addAll(res);
                if (shortest == null || shortest.size() > res.size()) {
                    shortest = list;
                }
            }
        }
        memo.put(target, shortest);
        return memo.get(target);
    }

    public List<Integer> bestSumDP(int[] numbers, int target) {
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        for (int i = 0; i < target; i ++) dp.add(null);
        for (int i = 0; i <= target; i ++) {
            for (int num : numbers) {
                int index = num + i;
                if (dp.get(i) == null || index > target) continue;
                List<Integer> temp = new ArrayList<>(dp.get(i));
                temp.add(0, num);
                if (dp.get(index) == null || dp.get(index).size() > temp.size()) dp.set(index, temp);
            }
        }
        return dp.get(target);
    }

}
