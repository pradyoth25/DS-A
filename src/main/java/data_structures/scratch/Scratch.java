package data_structures.scratch;

public class Scratch {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addToHead(1);
        linkedList.addToHead(2);
        linkedList.addToTail(3);
        linkedList.printList();
        linkedList.reverse();
        linkedList.printList();
    }

    private static class ListNode {
        int val;
        ListNode next, prev;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private static class LinkedList {
        ListNode head;
        ListNode tail;

        public LinkedList() {
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.prev = head;
        }

        public void addToHead(int val) {
            ListNode temp = new ListNode(val);
            temp.next = head.next;
            temp.prev = head;
            head.next.prev = temp;
            head.next = temp;
        }

        public void addToTail(int val) {
            ListNode temp = new ListNode(val);
            temp.prev = tail.prev;
            temp.next = tail;
            tail.prev.next = temp;
            tail.prev = temp;
        }

        public void printList() {
            ListNode curr = head;
            while (curr != null) {
                System.out.print(curr.val + "->");
                curr = curr.next;
            }
        }


        public void reverse() {
            System.out.println("reverse");
            ListNode prev = null, curr = head;
            while (curr != null) {
                prev = curr.prev;
                curr.prev = curr.next;
                curr.next = prev;
                curr = curr.prev;
            }
            if (prev != null) head = prev.prev;
        }
    }

    private class CircularQueue {

        int[] arr;
        int front, rear, len;

        public CircularQueue(int n) {
            arr = new int[n];
            front = 0; rear = -1; len = 0;
        }

        public boolean isEmpty() {return len == 0;}
        public boolean isFull() {return len == arr.length;}
        public boolean enQ(int val) {
            if (isFull()) return false;
            rear = (rear + 1) % arr.length;
            arr[rear] = val;
            len ++;
            return true;
        }
        public boolean deQ() {
            if (isEmpty()) return false;
            front = (front + 1) % arr.length;
            len --;
            return true;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private class BST  {
        TreeNode root;

        public TreeNode insert(TreeNode root, int val) {
            if (root == null) root = new TreeNode(val);
            else {
                if (root.val > val) root.left = insert(root, val);
                else root.right = insert(root, val);
            }
            return root;
        }

        public boolean search(TreeNode root, int val) {
            if (root == null) return false;
            if (root.val == val) return true;
            else if (root.val > val) return search(root.left, val);
            else return search(root.right, val);
        }

        public TreeNode remove(TreeNode root, int key) {
            if (root == null) return null;
            if (root.val > key) root.left = remove(root.left, key);
            else if (root.val < key) root.right = remove(root.right, key);
            else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    TreeNode min = getMin(root.right);
                    root.val = min.val;
                    root.right = remove(root.right, min.val);
                }
            }
            return root;
        }
        private TreeNode getMin(TreeNode root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }

        int diam;
        public int diameter(TreeNode root) {
            diam = 0;
            helper(root);
            return diam - 1;
        }
        private int helper(TreeNode root) {
            if (root == null) return 0;
            int left = helper(root.left);
            int right = helper(root.right);
            diam = Math.max(diam, 1 + left + right);
            return 1 + Math.max(left, right);
        }
    }

}
