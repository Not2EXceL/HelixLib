package io.not2excel.collection;

import java.util.LinkedList;

/**
 * Created by Carter on 7/15/2015.
 */

/**
 * @param <E> Type
 */
public class LimitedQueue<E> extends LinkedList<E> {

    protected int limit;

    public LimitedQueue(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean add(E o) {
        super.addFirst(o);
        while (size() > limit) { super.removeLast(); }
        return true;
    }
}
