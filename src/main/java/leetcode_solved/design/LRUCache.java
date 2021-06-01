package leetcode_solved.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Node head, tail;
    Map<Integer, Node> cache;
    int size, capacity;
    public LRUCache(int n) {
        this.capacity = n;
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        updateNode(node);
        return node.val;
    }

    public void put(int key, int val) {
        Node node = cache.get(key);
        if (node != null) {
            node.val = val;
            updateNode(node);
        } else {
            Node temp = new Node();
            temp.key = key;
            temp.val = val;
            addToHead(temp);
            cache.put(key, temp);
            if (cache.size() > capacity) {
                removeLRUElement();
            }

        }
    }

    private void removeLRUElement() {
        Node tailI = popTail();
        cache.remove(tailI.key);
    }

    private Node popTail() {
        Node tailI = tail.prev;
        removeFromList(tailI);
        return tailI;
    }

    private void updateNode(Node node) {
        removeFromList(node);
        addToHead(node);
    }

    private void removeFromList(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private class Node {
        int key, val;
        Node next, prev;
    }

}
