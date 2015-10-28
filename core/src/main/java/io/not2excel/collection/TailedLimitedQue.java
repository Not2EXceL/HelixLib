package io.not2excel.collection;
/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of HelixLib.
 * 
 * HelixLib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

import java.util.LinkedList;

public class TailedLimitedQue<E> extends LimitedQueue<E>{

    private final LinkedList<E> pastItems;

    public TailedLimitedQue(int limit) {
        super(limit);
        this.pastItems = new LinkedList<>();
    }

    @Override
    public boolean add(E o) {
        super.add(o);
        while (size() > limit) {
            pastItems.add(0, super.removeLast());
        }
        return true;
    }

    private void addFromPast(){
        if(pastItems.size() != 0){
            super.addLast(pastItems.removeFirst());
        }
    }

    @Override
    public E remove(){
        return remove(size() - 1);
    }

    @Override
    public E remove(int position){
        E returned = super.remove(position);
        addFromPast();
        return returned;
    }


}
