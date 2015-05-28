/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
package io.not2excel.module.context;

import io.not2excel.annotation.NonThreadSafe;
import io.not2excel.annotation.ThreadSafe;
import io.not2excel.metadata.CoreMetadata;
import io.not2excel.module.annotation.AbstractModule;
import io.not2excel.module.annotation.ModuleInfo;
import lombok.Getter;

@AbstractModule
@ModuleInfo(id = "core", name = "Core Module")
public class CoreModule<P> implements Module {

    @Getter
    private final P owner;
    private CoreMetadata<P, Object> metadata;
    @Getter
    private ModuleInfo info = null;

    public CoreModule(ModuleInfo info, P owner) {
        this(owner);
        this.info = info;
    }

    public CoreModule(P owner) {
        this.owner = owner;
    }

    //region <Inherited methods if use case is required>

    @Override
    public void onLoad() {

    }

    @Override
    public void onUnload() {

    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    //endregion

    /**
     * True if metadata has been instantiated
     * Non-Thread safe check
     *
     * @return metadata exists or not
     */
    @NonThreadSafe
    public boolean hasMetadata() {
        return metadata != null;
    }

    /**
     * Returns the metadata object for this module
     * Lazy (double locked) instantiates the metadata object if null
     *
     * @return metadata
     * @since 0.1.0
     */
    @ThreadSafe
    public CoreMetadata getMetadata() {
        if (metadata == null) {
            synchronized (this) {
                if (metadata == null) {
                    metadata = new CoreMetadata<>();
                }
            }
        }
        return metadata;
    }
}
