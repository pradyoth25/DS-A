package data_structures;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Iterator;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkedList<T> implements Iterable<T> {

    int size = 0;
    Node<T> head = null;
    Node<T> tail = null;

    public void clear() {
        Node<T> temp = head;
        while (temp != null) {
            Node<T> next = temp.next;
            nullifyNode(temp);
            temp = next;
        }
        head = null;
        tail = null;
        temp = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T elem) {
        addLast(elem);
    }

    public void addLast(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addAt(int index, T data) throws Exception {
        if (index < 0) {
            throw new Exception("Illegal index");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node<T> newNode = new Node<T>(data, temp, temp.next);
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        T data = head.data;
        head = head.next;
        --size;

        if (isEmpty()) tail = null;
        else head.prev = null;

        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        T data = tail.data;
        tail = tail.prev;
        --size;

        if (isEmpty()) head = null;
        else tail.next = null;

        return data;
    }

    private T remove(Node<T> node) {
        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();

        Node<T> savedNext = node.next;
        Node<T> savedPrev = node.prev;

        savedPrev.next = savedNext;
        savedNext.prev = savedPrev;

        T data = node.data;

        nullifyNode(node);
        node = null;

        --size;
        return data;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index");
        }
        Node<T> temp = head;
        for (int i = 0; i != index; i++) {
            temp = temp.next;
        }
        return remove(temp);
    }

    public boolean remove(Object object) {
        Node<T> temp = head;
        while (temp != null) {
            if (object.equals(temp.data)) {
                remove(temp);
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(Object object) {
        int index = 0;
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(object)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    private void nullifyNode(Node<T> temp) {
        temp.prev = null;
        temp.next = null;
        temp.data = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> temp = head;
        while (temp != null) {
            sb.append(temp.data);
            if (temp.next != null) {
                sb.append(", ");
            }
            temp = temp.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    private static class Node<T> {
        T data;
        Node<T> next, prev;

        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
