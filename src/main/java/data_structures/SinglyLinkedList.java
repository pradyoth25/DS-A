package data_structures;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Iterator;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class SinglyLinkedList<T> implements Iterable<T> {

    int size;
    Node<T> head;

    public void clear() {
        Node<T> temp = head;
        while (temp != null) {
            Node<T> next = temp.next;
            temp.next = null;
            temp.data = null;
            temp = next;
        }
        head = temp = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void add(T elem) {
        addLast(elem);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> temp = head;
        while (temp.next != null) {
            sb.append(temp.data).append(", ");
            temp = temp.next;
        }
        sb.append(temp.data).append("]");
        return sb.toString();
    }

    private void addLast(T elem) {
        if (isEmpty()) {
            head = new Node(elem, null);
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(elem, null);
        }
        size++;
    }

    public void addFirst(T elem) {
        if (isEmpty()) {
            head = new Node(elem, null);
        } else {
            Node temp = head;
            head = new Node(elem, temp);
        }
        size++;
    }

    public void addAt(T elem, int index) {
        if (index == 0) {
            addFirst(elem);
            return;
        } else if (index >= size) {
            addLast(elem);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node<T> next = temp.next;
        temp.next = new Node(elem, next);

        size++;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        T data = head.data;
        head = head.next;
        --size;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        Node<T> temp = head;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        T data = temp.next.data;
        temp.next = null;
        return data;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
