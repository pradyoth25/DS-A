package data_structures;

import java.util.*;

public class BinaryTreeTraversals {

    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }
    }

    public static List<Integer> inorderI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static List<Integer> preorderI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

    public static void preorder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.val);
        }
    }

    public static List<Integer> postOrderI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                res.add(0, root.val);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        return res;
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> res = new ArrayList<>();
        populateNodes(root, 0, 0, res);
        Map<Integer, List<Node>> map = new HashMap<>();
        for (Node n : res) {
            int key = n.x;
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(n);
        }
        // System.out.println(map);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            min = Math.min(min, key);
            max = Math.max(min, key);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            List<Node> vertical = map.getOrDefault(i, new ArrayList<>());
            Collections.sort(vertical, (a, b) -> a.root.val - b.root.val);
            List<Integer> temp = new ArrayList<>();
            for (Node n : vertical) temp.add(n.root.val);
            result.add(new ArrayList<>(temp));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        TreeNode ll = new TreeNode(1);
        TreeNode lr = new TreeNode(3);
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(7);
        root.left = left;
        root.right = right;
        left.left = ll;
        left.right = lr;
        right.left = rl;
        right.right = rr;
        System.out.println("inorder");
        inorder(root);
        System.out.println("preorder");
        preorder(root);
        System.out.println("postorder");
        postorder(root);
        System.out.println(inorderI(root));
        System.out.println(preorderI(root));
        System.out.println(postOrderI(root));
    }

    private static void populateNodes(TreeNode root, int x, int y, List<Node> res) {
        if (root == null) return;
        Node curr = new Node(x, y, root);
        System.out.println("creating node " + x + " " + y + " " + root.val);
        res.add(curr);
        if (root.left != null) populateNodes(root.left, x - 1, y - 1, res);
        if (root.right != null) populateNodes(root.right, x + 1, y - 1, res);
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class Node {
        int x, y;
        TreeNode root;

        public Node(int x, int y, TreeNode root) {
            this.x = x;
            this.y = y;
            this.root = root;
        }
    }
}
