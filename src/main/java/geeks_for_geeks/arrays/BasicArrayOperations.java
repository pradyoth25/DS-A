package geeks_for_geeks.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class BasicArrayOperations {

    public void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public int findMaxElement(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
        }
        return max;
    }

    public int findMinElement(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            if (num < min) min = num;
        }
        return min;
    }

    public int findKthSmallestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.remove();
        }
        return pq.isEmpty() ? -1 : pq.peek();
    }

    public void dutchNationalFlagSort(int[] nums) {
        int l = 0, m = 0, r = nums.length - 1;
        while (m <= r) {
            if (nums[m] == 0) {
                swap(nums, l, m);
                l ++; m ++;
            } else if (nums[m] == 1) {
                m ++;
            } else {
                swap(nums, m, r);
                r --;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public void shiftAllNegativeElementsToLeft(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] < 0 && nums[r] < 0) {
                l ++;
            } else if (nums[l] > 0 && nums[r] < 0) {
                swap(nums, l, r);
                l ++; r --;
            } else if (nums[l] > 0 && nums[r] > 0) {
                r --;
            } else {
                l ++; r --; // when they're both zero
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
