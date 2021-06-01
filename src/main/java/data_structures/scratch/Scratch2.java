package data_structures.scratch;

public class Scratch2 {

    class DArray {
        int[] arr;
        int len, capacity;

        public DArray(int capacity) {
            arr = new int[capacity];
            this.len = 0;
            this.capacity = 0;
        }

        public DArray() {
            arr = new int[16];
            this.len = 0;
            this.capacity = 16;
        }

        public int size() {
            return this.len;
        }

        public boolean isEmpty() {
            return this.len == 0;
        }

        public void set(int index, int value) {
            this.arr[index] = value;
        }

        public void add(int value) {
            if (len + 1 >= capacity) {
                System.out.println("Resizing");
                if (capacity == 0) capacity = 1;
                else capacity *= 2;
                int[] newArray = new int[capacity];
                for (int i = 0; i < len; i++) newArray[i] = arr[i];
                this.arr = newArray;
            }
            arr[len++] = value;
        }

        public int removeAt(int index) {
            int data = this.arr[index];
            int[] newArray = new int[this.capacity - 1];
            int pointer = 0;
            for (int i = 0; i < this.len; i++) {
                if (i == index) pointer--;
                else newArray[pointer] = arr[i];
            }
            this.arr = newArray;
            len--;
            this.capacity = len;
            return data;
        }
    }

    static class MinHeap {
        int[] heap;
        int size, maxSize;
        int FRONT = 1;

        public MinHeap(int maxSize) {
            this.maxSize = maxSize;
            this.size = 0;
            this.heap = new int[this.maxSize + 1];
            heap[0] = Integer.MIN_VALUE;
        }

        private int getParent(int pos) {
            return pos / 2;
        }

        private int getLeftChild(int pos) {
            return 2 * pos;
        }

        private int getRightChild(int pos) {
            return 2 * pos + 1;
        }

        private boolean isLeaf(int pos) {
            return pos >= (size / 2) && pos <= size;
        }

        private void swap(int i, int j) {
            int temp = this.heap[i];
            this.heap[i] = this.heap[j];
            this.heap[j] = temp;
        }

        private void minHeapify(int pos) {
            if (isLeaf(pos)) return;
            // If a node is not a leaf, and is greater than any of its children, swap the node with the smaller child
            // And continue the heapify process
            if (this.heap[pos] > this.heap[getLeftChild(pos)] || this.heap[pos] > this.heap[getRightChild(pos)]) {
                if (this.heap[getLeftChild(pos)] < this.heap[getRightChild(pos)]) {
                    swap(pos, getLeftChild(pos));
                    minHeapify(getLeftChild(pos));
                } else {
                    swap(pos, getRightChild(pos));
                    minHeapify(getRightChild(pos));
                }
            }

        }

        public void insert(int value) {
            this.size++;
            this.heap[size] = value;
            int curr = size;
            while (this.heap[curr] < this.heap[getParent(curr)]) {
                swap(curr, getParent(curr));
                curr = getParent(curr);
            }
        }

        public void minHeap() {
            for (int pos = size / 2; pos >= 1; pos--) minHeapify(pos);
        }

        public int remove() {
            int popVal = this.heap[FRONT];
            this.heap[FRONT] = this.heap[size--];
            minHeapify(FRONT);
            return popVal;
        }

        public void print() {
            for (int i = 1; i <= size / 2; i++) {
                System.out.print(" PARENT : " + this.heap[i] + " LEFT CHILD : " + this.heap[2 * i] + " RIGHT CHILD :" + this.heap[2 * i + 1]);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();

        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());
    }

}
