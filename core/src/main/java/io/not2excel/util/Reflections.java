/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of module-api.
 * 
 * module-api can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
package io.not2excel.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

public final class Reflections {

    /**
     * Retrieves the annotation object on a class
     *
     * @param clazz      target
     * @param annotation annotation class
     * @param <T>        annotation type
     * @return annotation object
     * @throws RuntimeException if annotation is not present
     */
    public static <T extends Annotation> T getAnnotation(Class<?> clazz, Class<T> annotation) {
        if (!hasAnnotation(clazz, annotation)) {
            throw new RuntimeException(annotation.getSimpleName() + " is not present on target " + clazz.getSimpleName());
        }
        return clazz.getAnnotation(annotation);
    }

    /**
     * Wrapper method for checking if an annotation is present on a class
     *
     * @param clazz      target
     * @param annotation annotation class
     * @return is present of not
     */
    public static boolean hasAnnotation(Class<?> clazz, Class<? extends Annotation> annotation) {
        return clazz.isAnnotationPresent(annotation);
    }

    /**
     * Simply initializes a class via the location constructor with the provided args and argClasses
     *
     * @param clazz Class to initialize
     * @param args  args for constructor
     * @return initialized objects
     * @throws Exception
     */
    public static Object initConstructor(Class<?> clazz, Object[] args) throws Exception {
        Constructor<?> constructor;
        Class<?>[] argClasses = new Class[0];
        if (args != null && args.length > 0) {
            argClasses = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argClasses[i] = args[i].getClass();
            }
        }
        constructor = clazz.getConstructor(argClasses);
        return constructor.newInstance(args);
    }
}
