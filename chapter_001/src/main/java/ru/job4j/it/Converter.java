package ru.job4j.it;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> inIterator = Collections.emptyIterator();

            @Override
            public boolean hasNext() {
                while (!inIterator.hasNext() && it.hasNext()) {
                    this.inIterator = it.next();
                }
                return inIterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return inIterator.next();
            }
        };
    }
}
