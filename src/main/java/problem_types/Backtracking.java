package problem_types;

import java.util.*;

public class Backtracking {

    /**
     * Permute all the numbers in an array
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(nums, new ArrayList<>(), new HashSet<>(), res);
        return res;
    }

    private void helper(int[] nums, List<Integer> temp, Set<Integer> tSet, List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int num : nums) {
            if (tSet.contains(num)) continue;
            temp.add(num);
            tSet.add(num);
            helper(nums, temp, tSet, res);
            temp.remove(temp.size() - 1);
            tSet.remove(num);
        }
    }

    /**
     * Permute only unique values
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    private void helper(int[] nums, List<Integer> temp, boolean[] used, List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            temp.add(nums[i]);
            used[i] = true;
            helper(nums, temp, used, res);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    /**
     * Generate all subsets of an array
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, int pos, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = pos; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * Generate subsets with duplicates values as well
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), 0, res);
        return res;
    }

    private void helper(int[] nums, List<Integer> temp, int pos, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            helper(nums, temp, i + 1, res);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * Generate combination sum with duplicates
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), 0, res);
        return res;
    }

    private void helper(int[] candidates, int target, List<Integer> temp, int pos, List<List<Integer>> res) {
        if (target < 0) return;
        else if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = pos; i < candidates.length; i++) {
                if (i > pos && candidates[i] == candidates[i - 1]) continue;
                temp.add(candidates[i]);
                helper(candidates, target - candidates[i], temp, i + 1, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    /**
     * Generate all subsets of palindromic partitions
     */
    public List<List<String>> partitionPalindromes(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(s, new ArrayList<>(), 0, res);
        return res;
    }

    private void helper(String s, List<String> temp, int pos, List<List<String>> res) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome(s, pos, i)) {
                temp.add(s.substring(pos, i + 1));
                helper(s, temp, i + 1, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}
