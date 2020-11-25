package data_structures;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Iterator;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkedList<T> implements Iterable<T> {

    int size = 0;
    Node<T> head;
    Node<T> tail;

    public void clear() {
        Node<T> temp = head;
        while (temp != null) {
            Node<T> next = temp.next;
            temp.prev = null;
            temp.next = null;
            temp.data = null;
            temp = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class Node<T> {
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
