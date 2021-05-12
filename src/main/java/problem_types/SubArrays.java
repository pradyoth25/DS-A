package problem_types;

import java.util.HashMap;
import java.util.Map;

public class SubArrays {

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and return its sum.
     */
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], nums[i] + maxEndingHere);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }

    /**
     * Given an array of positive integers nums and a positive integer target,
     * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1,
     * numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
     */
    public int minSubArrayLen(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r++];
            while (sum >= target) {
                minLen = Math.min(minLen, r - l);
                sum -= nums[l++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    /**
     * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
     * and return the product.
     */
    public int maxProduct(int[] nums) {
        int maxProd = nums[0], minProd = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tempMax = Math.max(num, Math.max(num * maxProd, num * minProd));
            minProd = Math.min(num, Math.min(num * minProd, num * maxProd));
            maxProd = tempMax;
            res = Math.max(res, maxProd);
        }
        return res;
    }

    /**
     * Given an array of integers nums and an integer k,
     * return the total number of continuous subarrays whose sum equals to k.
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    /**
     * Given an array A of integers, return the number of
     * (contiguous, non-empty) subarrays that have a sum divisible by K.
     */
    public int subarraysDivByK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;
            sum %= k;
            if (sum < 0) sum += k;
            res += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    /**
     * You are given an integer array nums consisting of n elements, and an integer k.
     * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
     */
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int m = nums.length;
        double sum = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                res = Math.max(res, sum / k);
                sum -= nums[i - k + 1];
            }
        }
        return res;
    }

}
