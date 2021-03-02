package algorithms.sorting;

public class QuickSort {

    public void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }
    private void quickSortHelper(int[] nums, int l, int r) {
        if (l < r) {
            int pivot = partition(nums, l, r);
            quickSortHelper(nums, l, pivot - 1);
            quickSortHelper(nums, pivot + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int left = l - 1;
        for (int i = l; i < r; i ++) {
            if (nums[i] <= pivot) {
                left ++;
                swap(nums, left, i);
            }
        }
        swap(nums, left + 1, r);
        return left + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
