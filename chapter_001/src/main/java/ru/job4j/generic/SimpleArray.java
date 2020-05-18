package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] data;
    private int point = 0;

    public SimpleArray(int size) {
        this.data = new Object[size];
    }

    public void add(T model) {
        data[point++] = model;
    }

    public void set(int index, T model) {
        try {
            data[Objects.checkIndex(index, point)] = model;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    public void remove(int index) {
        try {
            for (int i = Objects.checkIndex(index, point); i < data.length - 1; i++) {
                data[i] = data[i + 1];
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    public T get(int index) {
        try {
            return (T) data[Objects.checkIndex(index, point)];
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < point;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[index++];
            }
        };
    }
}
