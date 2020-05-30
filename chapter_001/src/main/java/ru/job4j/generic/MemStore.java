package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean flag = false;
        ListIterator<T> it = mem.listIterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.set(model);
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean delete(String id) {
        int index = indexOf(id);
        boolean rsl = false;
        if (index != -1) {
            mem.remove(index);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        int index = indexOf(id);
        if (index != -1) {
            return mem.get(index);
        } else {
            return null;
        }
    }

    private int indexOf(String id) {
        int rsl = -1;
        int index = 0;
        for (T member : mem) {
            if (member.getId().equals(id)) {
                rsl = index;
            }
            index++;
        }
        return rsl;
    }
}
