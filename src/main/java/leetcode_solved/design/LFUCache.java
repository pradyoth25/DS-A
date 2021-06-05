package leetcode_solved.design;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    int capacity, currSize, minFreq;
    Map<Integer, Node> cache;
    Map<Integer, DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFreq = 0;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        updateNode(node);
        return node.val;
    }

    private void updateNode(Node curr) {
        int currFreq = curr.freq;
        DLL currList = freqMap.get(currFreq);
        currList.removeNode(curr);
        if (currFreq == minFreq && currList.lSize == 0) this.minFreq++;
        curr.freq++;
        DLL newList = freqMap.getOrDefault(curr.freq, new DLL());
        newList.addToHead(curr);
        freqMap.put(curr.freq, newList);
    }

    public void put(int key, int value) {
        if (this.capacity == 0) return;
        Node curr = cache.get(key);
        if (curr != null) {
            curr.val = value;
            updateNode(curr);
        } else {
            this.currSize++;
            if (this.currSize > this.capacity) {
                DLL minList = freqMap.get(minFreq);
                Node tail = minList.removeTail();
                cache.remove(tail.key);
                this.currSize--;
            }
            minFreq = 1;
            Node temp = new Node(key, value);
            cache.put(key, temp);
            DLL currList = freqMap.getOrDefault(1, new DLL());
            currList.addToHead(temp);
            freqMap.put(1, currList);
        }
    }

    class Node {
        int key, val, freq;
        Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DLL {
        Node head, tail;
        int lSize;

        public DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            this.lSize = 0;
        }

        public void addToHead(Node curr) {
            curr.next = head.next;
            curr.prev = head;
            head.next.prev = curr;
            head.next = curr;
            this.lSize++;
        }

        public void removeNode(Node node) {
            Node next = node.next;
            Node prev = node.prev;
            next.prev = prev;
            prev.next = next;
            this.lSize--;
        }

        public Node removeTail() {
            Node tailI = tail.prev;
            removeNode(tailI);
            return tailI;
        }
    }
}

