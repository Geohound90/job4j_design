package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] data;
    private int point = -1;
    private int nextPoint = -1;

    public EvenIt(final int[] data) {
        this.data = data;
    }

    public int findIndexOfEvenElement() {
        for (int index = point + 1; index < data.length; index++) {
            if (data[index] % 2 == 0) {
                nextPoint = index;
                break;
            }
        }
        return nextPoint;
    }

    @Override
    public boolean hasNext() {
        return point < nextPoint || point != findIndexOfEvenElement();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        point = nextPoint;
        return data[point];
    }
}
