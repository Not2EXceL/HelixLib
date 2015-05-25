/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
package io.not2excel.module.coordinator;

import io.not2excel.module.annotation.AbstractModule;
import io.not2excel.module.annotation.ModuleInfo;
import io.not2excel.module.context.CoreModule;
import io.not2excel.module.exception.ModuleLoadException;
import io.not2excel.plugin.CorePlugin;
import io.not2excel.util.Reflections;
import lombok.Getter;
import org.apache.logging.log4j.Level;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoreModuleCoordinator<P extends CorePlugin> extends SimpleModuleCoordinator<CoreModule> {

    @Getter
    private final List<String> excludes;
    @Getter
    private final P corePlugin;

    public CoreModuleCoordinator(P corePlugin, List<String> excludes) {
        super(CoreModule.class);
        this.corePlugin = corePlugin;
        this.excludes = excludes;
    }
    
    public CoreModuleCoordinator(P corePlugin) {
        this(corePlugin, Collections.emptyList());
    }
    
    public CoreModuleCoordinator(P corePlugin, String... excludes) {
        this(corePlugin, Arrays.asList(excludes));
    }

    @Override
    public CoreModule instantiate(Class<CoreModule> moduleClass) {
        if (Reflections.hasAnnotation(moduleClass, AbstractModule.class)) {
            logger.log(Level.INFO, String.format("Skipping instantiation of abstract module %s", moduleClass.getSimpleName()));
            return null;
        }
        try {
            ModuleInfo moduleInfo = super.getModuleInfo(moduleClass);
            Constructor<?> constructor = moduleClass.getDeclaredConstructor(ModuleInfo.class, corePlugin.getClass());
            constructor.setAccessible(true);
            return (CoreModule) constructor.newInstance(moduleInfo, corePlugin);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void load(CoreModule module) throws ModuleLoadException {
        ModuleInfo info = module.getModuleInfo();
        if(info == null) {
            info = super.getModuleInfo(module.getClass());
        }
        if(!excludes.contains(info.id())) {
            super.load(module);
        } else {
            super.logger.info(excludeMessage(info));
        }
    }

    @Override
    public void load(Class<CoreModule> moduleClass) {
        ModuleInfo info = super.getModuleInfo(moduleClass);
        if(!excludes.contains(info.id())) {
            super.load(moduleClass);
        } else {
            super.logger.info(excludeMessage(info));
        }
    }

    private String excludeMessage(ModuleInfo info ) {
        return info.id() + " => Found in excludes. Skipping loading.";
    }
}
