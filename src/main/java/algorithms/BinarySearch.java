package algorithms;

public class BinarySearch {

    int[] nums = new int[100];

    public int templateOne(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    /**
     * Most basic and elementary form of Binary Search
     * Search Condition can be determined without comparing to the element's neighbors (or use specific elements around it)
     * No post-processing required because at each step, you are checking to see if the element has been found. If you reach the end, then you know the element is not found
     *
     * Initial Condition: left = 0, right = length-1
     * Termination: left > right
     * Searching Left: right = mid-1
     * Searching Right: left = mid+1
     */

    public int templateTwo(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] ==  target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        if (l != nums.length && nums[l] ==  target) return l;
        return -1;
    }

    /**
     * An advanced way to implement Binary Search.
     * Search Condition needs to access element's immediate right neighbor
     * Use element's right neighbor to determine if condition is met and decide whether to go left or right
     * Guarantees Search Space is at least 2 in size at each step
     * Post-processing required. Loop/Recursion ends when you have 1 element left. Need to assess if the remaining element meets the condition.
     *
     * Initial Condition: left = 0, right = length; Sometimes right can be length - 1 also
     * Termination: left == right
     * Searching Left: right = mid
     * Searching Right: left = mid+1
     */

    public int templateThree(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid;
            else r = mid;
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }

    /**
     * An alternative way to implement Binary Search
     * Search Condition needs to access element's immediate left and right neighbors
     * Use element's neighbors to determine if condition is met and decide whether to go left or right
     * Guarantees Search Space is at least 3 in size at each step
     * Post-processing required. Loop/Recursion ends when you have 2 elements left. Need to assess if the remaining elements meet the condition.
     *
     * Initial Condition: left = 0, right = length-1; Sometimes "right" can be length
     * Termination: left + 1 == right
     * Searching Left: right = mid
     * Searching Right: left = mid
     */


}
