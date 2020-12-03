package data_structures;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyQueue<T> implements Iterable<T> {

    List<T> list = new LinkedList<>();

    public MyQueue() {
    }

    public MyQueue(T elem) {
        enqueue(elem);
    }

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void enqueue(T elem) {
        list.add(list.size(), elem);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T elem = list.get(0);
        list.remove(0);
        return elem;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(0);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
