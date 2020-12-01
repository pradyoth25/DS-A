package data_structures;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyStack<T> implements Iterable<T> {

    LinkedList<T> list = new LinkedList<>();

    public MyStack() {
    }

    public MyStack(T firstElem) {
        push(firstElem);
    }

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void push(T elem) {
        list.addLast(elem);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeLast();
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.peekLast();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
