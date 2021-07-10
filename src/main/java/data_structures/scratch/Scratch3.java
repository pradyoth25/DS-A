package data_structures.scratch;

public class Scratch3 {

    public void mergeSort(int[] nums) {
        int n = nums.length;
        if (n < 2) return;
        int mid = n / 2;
        int[] l = new int[mid], r = new int[n - mid];
        for (int i = 0; i < mid; i++) l[i] = nums[i];
        for (int i = mid; i < n; i++) r[i - mid] = nums[i];
        mergeSort(l);
        mergeSort(r);
        merge(nums, l, r);
    }

    private void merge(int[] nums, int[] l, int[] r) {
        int i = 0, j = 0, k = 0;
        while (i < l.length && j < r.length) {
            if (l[i] <= r[j]) nums[k] = l[i++];
            else nums[k] = r[j++];
            k++;
        }
        while (i < l.length) nums[k++] = l[i++];
        while (j < r.length) nums[k++] = r[j++];
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = partition(nums, l, r);
            quickSort(nums, l, mid - 1);
            quickSort(nums, mid + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int left = l - 1;
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                left++;
                swap(nums, i, left);
            }
        }
        left++;
        swap(nums, left, r);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private class BinarySearchTree {
        TreeNode root;

        public TreeNode insert(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            else if (val < root.val) root.left = insert(root.left, val);
            else root.right = insert(root.right, val);
            return root;
        }

        public TreeNode deleteNode(TreeNode root, int val) {
            if (root == null) return null;
            if (val < root.val) root.left = deleteNode(root.left, val);
            else if (val > root.val) root.right = deleteNode(root.right, val);
            else {
                if (root.left == null) return root.right;
                else if (root.right == null) return root.left;
                else {
                    TreeNode min = getMin(root.right);
                    root.val = min.val;
                    root.right = deleteNode(root.right, min.val);
                }
            }
            return root;
        }

        public boolean search(TreeNode root, int val) {
            if (root.val == val) return true;
            else if (val < root.val) return search(root.left, val);
            else return search(root.right, val);
        }

        private TreeNode getMin(TreeNode root) {
            while (root.left != null) root = root.left;
            return root;
        }
    }


}
