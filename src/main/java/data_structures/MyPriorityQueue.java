package data_structures;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.*;

/**
 * This is a MinHeap.
 * Removals: O(log(n))
 * Find: O(1)
 * Min: O(1)
 *
 * @param <T> - Typed parameter
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyPriorityQueue<T extends Comparable<T>> {

    List<T> heap;
    Map<T, TreeSet<Integer>> map = new HashMap<>();

    /**
     * Construct a PQ with an initial capacity
     * @param size - capacity
     */
    public MyPriorityQueue(int size) {
        heap = new ArrayList<>(size);
    }

    /**
     * Initially empty PQ with size - 1
     */
    public MyPriorityQueue() {
        this(1);
    }

    /**
     * PQ using "heapify" in O(n) time.
     * @param elements - which is an array
     */
    public MyPriorityQueue(T[] elements) {
        int heapSize = elements.length;
        heap = new ArrayList<>(heapSize);

        for (int i = 0; i < heapSize; i++) {
            mapAdd(elements[i], i);
            heap.add(elements[i]);
        }

        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) {
            // start off from half the size of the heap and then keep sinking indices
            sink(i);
        }
    }

    /**
     * This given O(nlog(n)) time creation
     * @param elements - which is a collection
     */
    public MyPriorityQueue(Collection<T> elements) {
        this(elements.size());
        for (T elem : elements) add(elem);
    }

    /**
     * O(1)
     * @return the min element in the PQ
     */
    public T peek() {
        if (isEmpty()) return null;
        return heap.get(0);
    }

    /**
     * O(log(n))
     * @return the first element in the PQ (min element)
     */
    public T poll() {
        return removeAt(0);
    }

    /**
     * O(1)
     * @param elem - element to check
     * @return true if the elem exists in the PQ
     */
    public boolean contains(T elem) {
        if (elem == null) return false;
        return map.containsKey(elem);
    }

    /**
     * O(log(n))
     * @param elem - to be added to the PQ
     */
    public void add(T elem) {
        if (elem == null) throw new IllegalArgumentException();
        heap.add(elem);
        int indexOfLastElem = getSize() - 1;
        mapAdd(elem, indexOfLastElem);
        swim(indexOfLastElem);
    }

    /**
     * Removes an element in O(log(n)) time
     * @param element - to be removed
     * @return true or false based on whether the element was found or not
     */
    public boolean remove(T element) {
        if (element == null) return false;
        Integer index = mapGet(element);
        if (index != null) removeAt(index);
        return index != null;
    }

    /**
     * Checks if this heap is a min heap
     * @param k - index at which the heap checking has to be done
     * @return true or false based on whether the heap invariant is satisfied or not
     */
    public boolean isMinHeap(int k) {
        int heapSize = getSize();
        if (k >= heapSize) return true;

        int left = 2 * k + 1;
        int right = 2 * k + 2;

        if (left < heapSize && !less(k, left)) return false;
        if (right < heapSize && !less(k, right)) return false;

        return isMinHeap(left) && isMinHeap(right);
    }

    /**
     * @return the size of the heap
     */
    public int getSize() {
        return heap.size();
    }

    /**
     * @return true if the PQ is empty
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Clears the PQ
     */
    public void clear() {
        heap.clear();
        map.clear();
    }

    // PRIVATE METHODS

    // Removes a node at a particular index O(log(n)) and returns it
    private T removeAt(int index) {
        if (isEmpty()) return null;
        int indexOfLastElem = getSize() - 1;
        T removedData = heap.get(index);
        swap(index, indexOfLastElem);

        heap.remove(indexOfLastElem);
        mapRemove(removedData, indexOfLastElem);

        if (index == indexOfLastElem) {
            return removedData;
        }

        T elem = heap.get(index);
        sink(index);

        if (heap.get(index).equals(elem)) swim(index);

        return removedData;
    }

    // Checks if node_i is <= node_j in O(1)
    private boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);
        return node1.compareTo(node2) <= 0;
    }

    // Swaps the ith and jth element in the "list" and also swaps them in the map
    private void swap(int i, int j) {
        T ithElem = heap.get(i);
        T jthElem = heap.get(j);

        heap.set(i, jthElem);
        heap.set(j, ithElem);

        mapSwap(ithElem, jthElem, i, j);
    }

    // Sink and Swim

    /**
     * Sinking process in O(log(n))
     * Gets the left and right children for the given index (k)
     * @param k - index at which the sink should begin
     */
    private void sink(int k) {
        int heapSize = getSize();
        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left;

            if (right < heapSize && less(right, left)) {
                smallest = right;
            }

            if (left >= heapSize || less(k, smallest)) break;

            swap(smallest, k);
            k = smallest;
        }
    }

    // Bottom up node swim, O(log(n))
    private void swim(int k) {
        int parent = (k - 1) / 2;
        while (k > 0 && less(k, parent)) {
            swap(parent, k);
            k = parent;
            parent = (k - 1) / 2;
        }
    }

    // Map methods

    // Checks if a given "value" exists in the map, if it does, adds the index to its indices
    // Else, it adds a new entry with that index in the map
    private void mapAdd(T value, int index) {
        TreeSet<Integer> indices = map.get(value);
        if (indices == null) {
            indices = new TreeSet<>();
            indices.add(index);
            map.put(value, indices);
        } else {
            indices.add(index);
        }
    }

    // Checks if a value exists in the map, if it does, returns the last index, else returns null
    private Integer mapGet(T value) {
        TreeSet<Integer> indices = map.get(value);
        if (indices != null) return indices.last();
        return null;
    }

    // Removes an index from the set of indices for a value.
    // If the size of the indices list is 0, then the value is removed from the map
    private void mapRemove(T value, int index) {
        TreeSet<Integer> indices = map.get(value);
        indices.remove(index);
        if (indices.size() == 0) {
            map.remove(value);
        }
    }

    // Exchange the index of two nodes internally within the map
    private void mapSwap(T val1, T val2, int val1Index, int val2Index) {
        Set<Integer> set1 = map.get(val1);
        Set<Integer> set2 = map.get(val2);

        set1.remove(val1Index);
        set2.remove(val2Index);

        set1.add(val2Index);
        set2.add(val1Index);
    }

    @Override
    public String toString() {
        return heap.toString();
    }

}
