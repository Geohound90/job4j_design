package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAddElements() {
        SimpleArray<Integer> arr = new SimpleArray<>(3);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        assertThat(arr.get(0), is(1));
        assertThat(arr.get(1), is(2));
        assertThat(arr.get(2), is(3));
    }

    @Test
    public void whenRemoveElement() {
        SimpleArray<Integer> arr = new SimpleArray<>(3);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.remove(1);
        assertThat(arr.get(1), is(3));
    }

    @Test
    public void whenSetNewValueToElement() {
        SimpleArray<Integer> arr = new SimpleArray<>(3);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.set(1, 5);
        assertThat(arr.get(1), is(5));
    }
}