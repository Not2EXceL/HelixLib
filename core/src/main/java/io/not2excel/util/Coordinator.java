package io.not2excel.util;
/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of GuildsCore.
 * 
 * GuildsCore can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
        */
import java.util.HashMap;

public abstract class Coordinator<K, V, L> {

    protected final HashMap<K, V> coordinatorMap;

    protected Coordinator() {
        this.coordinatorMap = new HashMap<>();
    }

    public V get(K key){
        return coordinatorMap.get(key);
    }

    public V set(K key, V value){
        return coordinatorMap.put(key, value);
    }

    public boolean has(K key) { return coordinatorMap.containsKey(key); }

    public V remove(K key) { return coordinatorMap.remove(key); }

    abstract public void unload(K key);

    abstract public void unloadAll();

    abstract public void load(L load);

}
