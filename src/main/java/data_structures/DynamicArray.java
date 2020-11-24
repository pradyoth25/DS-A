package data_structures;

import io.swagger.annotations.ApiParam;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Iterator;

@FieldDefaults(level = AccessLevel.PRIVATE)
@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    T[] arr;
    int len = 0;
    int capacity = 0;

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public DynamicArray() {
        this(16);
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(@ApiParam("index") int index) {
        if (index < 0 || index >= len) {
            throw new IllegalArgumentException("Illegal index: " + index);
        }
        return arr[index];
    }

    public void set(int index, T elem) {
        if (index < 0 || index >= capacity) {
            throw new IllegalArgumentException("Illegal index: " + index);
        }
        arr[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T elem) {
        if (len + 1 >= capacity) {
            System.out.println("Array size doubling.");
            if (capacity == 0) capacity = 1;
            else capacity = capacity * 2;

            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
        arr[len++] = elem;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= len) {
            throw new IndexOutOfBoundsException();
        }
        T data = arr[index];
        T[] newArr = (T[]) new Object[len - 1];
        int pointer = 0;
        for (int i = 0; i < len; i++) {
            if (i == index) pointer--;
            else newArr[pointer] = arr[i];
        }
        arr = newArr;
        capacity = --len;
        return data;
    }

    public boolean remove(Object object) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(object)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object object) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < len;
            }

            public T next() {
                return arr[index++];
            }

            public void remove() {

            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < len - 1; i++) {
            sb.append(arr[i]).append(", ");
        }
        return sb.append(arr[len - 1]).append("]").toString();
    }

}
