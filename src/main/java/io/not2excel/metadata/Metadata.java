/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
package io.not2excel.metadata;

import java.util.Map;

/**
 * Interface for metadata key + value mapping with ownership
 *
 * @param <O>
 *         Owner type binding
 * @param <T>
 *         Value type binding
 *
 * @author not2excel
 * @version 0.1.0
 * @since 0.1.0
 */
public interface Metadata<O, T> {

    /**
     * Returns the current owner of the metadata object
     *
     * @return owner
     *
     * @since 0.1.0
     */
    O getOwner();

    /**
     * Sets the owner of this metadata object
     *
     * @param owner
     *         owner
     *
     * @since 0.1.0
     */
    void setOwner(final O owner);

    /**
     * Return the value if the key is valid
     *
     * @param key
     *         key
     *
     * @return value
     *
     * @since 0.1.0
     */
    T getValue(String key);

    /**
     * Insert a key + value pair to this metadata object
     *
     * @param key
     *         key
     * @param value
     *         value
     *
     * @since 0.1.0
     */
    void insertKeyValue(String key, T value);

    /**
     * Returns the inner pair mapping
     *
     * @return pair mapping
     *
     * @since 0.1.0
     */
    Map<String, T> getPairMap();

    /**
     * Validates that this metadata object contains the given key
     *
     * @param key
     *         key
     *
     * @return boolean if valid or not
     *
     * @since 0.1.0
     */
    default boolean validateKey(final String key) {
        return this.getPairMap().containsKey(key);
    }

    /**
     * Removes a specific key from this metadata object
     *
     * @param key
     *         key
     *
     * @since 0.1.0
     */
    default void invalidate(final String key) {
        if(this.validateKey(key)) {
            this.getPairMap().remove(key);
        }
    }
}
