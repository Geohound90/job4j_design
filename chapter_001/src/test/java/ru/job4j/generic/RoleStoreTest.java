package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RoleStoreTest {
    @Test
    public void whenAddElementAndGetHim() {
        RoleStore store = new RoleStore();
        Role[] roles = new Role[]{
                new Role("1"),
                new Role("2"),
                new Role("3"),
        };
        store.add(roles[0]);
        store.add(roles[1]);
        store.add(roles[2]);
        assertThat(store.findById("3"), is(roles[2]));
    }

    @Test
    public void whenReplaceElement() {
        RoleStore store = new RoleStore();
        Role[] roles = new Role[]{
                new Role("1"),
                new Role("2"),
                new Role("3"),
        };
        store.add(roles[0]);
        store.add(roles[1]);
        assertThat(store.replace("2", roles[2]), is(true));
        assertThat(store.findById("3"), is(roles[2]));
    }

    @Test
    public void whenDeleteElement() {
        RoleStore store = new RoleStore();
        Role[] roles = new Role[]{
                new Role("1"),
                new Role("2"),
                new Role("3"),
        };
        store.add(roles[0]);
        store.add(roles[1]);
        store.add(roles[2]);
        assertThat(store.findById("3"), is(roles[2]));
        assertThat(store.delete("3"), is(true));
        assertNull(store.findById("3"));
    }
}