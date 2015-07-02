/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
package io.not2excel.spigot.nms;

import io.not2excel.util.Reflections;
import org.bukkit.Bukkit;

import java.util.Optional;
import java.util.logging.Level;

public final class NMSFactory {

    private static Optional<String> nmsVersion;

    static {
        try {
            String parsedVersion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            nmsVersion = Optional.of(parsedVersion);
        } catch (ArrayIndexOutOfBoundsException e) {
            nmsVersion = Optional.empty();
            Bukkit.getLogger().log(Level.SEVERE, "Failed to parse NMS version.", e);
        }
    }

    /**
     * This is an extremely sinful hack. Better than spogit alternatives.
     *
     * @param className fully qualified name with {version} as a replacement for nmsVersion
     *                  will mutate to replace {version} with the actual version
     * @param <T>       super type
     * @return T type object
     * @throws Exception
     */
    public static <T> Optional<T> initializeClassPackage(Class<T> tClass, String className, Object... args) throws Exception {
        if (!nmsVersion.isPresent()) {
            return Optional.empty();
        }
        Class<?> clazz = Class.forName(className.replace("{version}", nmsVersion.get()));
        Object o = Reflections.initConstructor(clazz, args);
        if (!tClass.isInstance(o)) {
            return Optional.empty();
        }
        T t = tClass.cast(o);
        return Optional.ofNullable(t);
    }
}
