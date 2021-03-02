package algorithms.sorting;

public class WeirdSort {

    public void dutchNationalFlagSort(int[] arr) {
        // three pointer: i, j, k
        int start = 0, middle = 0, end = arr.length - 1;
        while (middle <= end) {
            if (arr[middle] == 0) {
                swap(arr, start, middle);
                start ++; middle ++;
            } else if (arr[middle] == 1) middle ++;
            else if (arr[middle] == 2) {
                swap(arr, middle, end);
                end --;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
