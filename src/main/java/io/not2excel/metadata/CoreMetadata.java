/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
package io.not2excel.metadata;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class CoreMetadata<O, T> implements Metadata<O, T>{

    @Getter
    @Setter
    private O owner;

    @Getter
    private final Map<String, T> pairMap;

    public CoreMetadata() {
        this.pairMap = new HashMap<>();
    }

    @Override
    public T getValue(String key) {
        return this.pairMap.get(key);
    }

    @Override
    public void insertKeyValue(String key, T value) {
        this.pairMap.put(key, value);
    }
}
