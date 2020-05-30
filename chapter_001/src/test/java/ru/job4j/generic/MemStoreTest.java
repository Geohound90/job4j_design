package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MemStoreTest {
    @Test
    public void whenAddElementAndGetHim() {
        MemStore store = new MemStore();
        User[] users = new User[] {
                new User("1"),
                new User("2"),
                new User("3"),
        };
        store.add(users[0]);
        store.add(users[1]);
        store.add(users[2]);
        assertThat(store.findById("3"), is(users[2]));
    }

    @Test
    public void whenReplaceElement() {
        MemStore store = new MemStore();
        User[] users = new User[] {
                new User("1"),
                new User("2"),
                new User("3"),
        };
        store.add(users[0]);
        store.add(users[1]);
        assertThat(store.replace("2", users[2]), is(true));
        assertThat(store.findById("3"), is(users[2]));
    }

    @Test
    public void whenDeleteElement() {
        MemStore store = new MemStore();
        User[] users = new User[] {
                new User("1"),
                new User("2"),
                new User("3"),
        };
        store.add(users[0]);
        store.add(users[1]);
        store.add(users[2]);
        assertThat(store.findById("3"), is(users[2]));
        assertThat(store.delete("3"), is(true));
        assertNull(store.findById("3"));
    }

}