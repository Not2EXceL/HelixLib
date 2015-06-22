/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
package io.not2excel.metadata;

import java.util.List;
import java.util.Map;

/**
 * Interface for metadata key + value mapping with ownership
 *
 * @param <P>
 *         Owner type binding
 * @param <T>
 *         Value type binding
 *
 * @author not2excel
 * @version 0.1.0
 * @since 0.1.0
 */
public interface Metadata<P, T> {

    /**
     * Returns the current owner of the metadata object
     *
     * @return owner
     *
     * @since 0.1.0
     */
    P getOwner();


    /**
     * Returns the inner pair mapping
     *
     * @return pair mapping
     *
     * @since 0.1.0
     */
    Map<String, T> getMetadataMap();

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
    default boolean has(final String key) {
        return this.getMetadataMap().containsKey(key);
    }

    default boolean hasList(String key) {
        return has(key) && this.getMetadataMap().get(key) instanceof List<?>;
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
        if(this.has(key)) {
            this.getMetadataMap().remove(key);
        }
    }
}
