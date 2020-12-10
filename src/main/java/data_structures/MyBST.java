package data_structures;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyBST<T extends Comparable<T>> {

    int nodeCount;
    Node root;

    public int getSize() {
        return nodeCount;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public boolean add(T elem) {
        if (contains(elem)) return false;
        else {
            root = add(root, elem);
            nodeCount++;
            return true;
        }
    }

    private Node add(Node root, T elem) {
        if (root == null) root = new Node(null, null, elem);
        else {
            if (elem.compareTo(root.data) < 0) root.left = add(root.left, elem);
            else root.right = add(root.right, elem);
        }
        return root;
    }

    public boolean contains(T elem) {
        return contains(root, elem);
    }

    private boolean contains(Node root, T elem) {
        if (root == null) return false;
        int cmp = elem.compareTo(root.data);
        if (cmp < 0) return contains(root.left, elem);
        else if (cmp > 0) return contains(root.right, elem);
        else return true;
    }

    public boolean remove(T elem) {
        if (contains(elem)) {
            root = remove(root, elem);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node root, T elem) {
        if (root == null) return null;
        int cmp = elem.compareTo(root.data);
        if (cmp < 0) root.left = remove(root.left, elem);
        else if (cmp > 0) root.right = remove(root.right, elem);
        else {
            if (root.left == null) {
                Node rightChild = root.right;
                root.data = null;
                root = null;
                return rightChild;
            } else if (root.right == null) {
                Node leftChild = root.left;
                root.data = null;
                root = null;
                return leftChild;
            } else {
                Node minLeftNode = getMin(root.right);
                root.data = minLeftNode.data;
                root.right = remove(root.right, minLeftNode.data);
            }
        }
        return root;
    }

    private Node getMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int getHeight() {
        return height(root);
    }

    public int height(Node root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public List<T> recursiveInorder() {
        List<T> res = new ArrayList<>();
        inorderRecursion(root, res);
        return res;
    }

    private void inorderRecursion(Node root, List<T> res) {
        if (root != null) {
            inorderRecursion(root.left, res);
            res.add(root.data);
            inorderRecursion(root.right, res);
        }
    }

    public List<T> recursivePreorder() {
        List<T> res = new ArrayList<>();
        preorderRecursion(root, res);
        return res;
    }

    private void preorderRecursion(Node root, List<T> res) {
        if (root != null) {
            res.add(root.data);
            preorderRecursion(root.left, res);
            preorderRecursion(root.right, res);
        }
    }

    public List<T> recursivePostorder() {
        List<T> res = new ArrayList<>();
        postorderRecursion(root, res);
        return res;
    }

    private void postorderRecursion(Node root, List<T> res) {
        if (root != null) {
            postorderRecursion(root.left, res);
            postorderRecursion(root.right, res);
            res.add(root.data);
        }
    }

    class Node {
        T data;
        Node left, right;

        public Node(Node left, Node right, T elem) {
            this.data = elem;
            this.left = left;
            this.right = right;
        }
    }

}
