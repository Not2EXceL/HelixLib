/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
package io.not2excel.module.coordinator;

import io.not2excel.module.context.CoreModule;

public class CoreModuleCoordinator extends SimpleModuleCoordinator<CoreModule> {

    public CoreModuleCoordinator() {
        super(CoreModule.class);
    }
}
