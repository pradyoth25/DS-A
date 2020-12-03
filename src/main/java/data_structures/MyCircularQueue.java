package data_structures;

public class MyCircularQueue {

    int[] arr;
    int rear;
    int front;
    int size;

    public MyCircularQueue(int size) {
        arr = new int[size];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public void enqueue(int elem) {
        if (isFull()) {
            return;
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = elem;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int val = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return val;
    }

    public int peekFirst() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public int peekLast() {
        if (isEmpty()) {
            return -1;
        }
        return arr[rear];
    }

}
