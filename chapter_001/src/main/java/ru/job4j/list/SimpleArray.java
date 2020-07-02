package ru.job4j.list;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] pack = new Object[10];
    private int index = 0;
    private int modCount = 0;
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) pack[Objects.checkIndex(index, this.index)];
    }

    public void add(T model) {
        if (index + 1 >= pack.length) {
            pack = Arrays.copyOf(pack, pack.length * 2);
        }
        pack[index++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            private final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < SimpleArray.this.index;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) pack[index++];
            }
        };
    }
}
