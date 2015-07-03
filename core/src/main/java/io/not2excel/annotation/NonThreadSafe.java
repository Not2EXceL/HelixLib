/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
package io.not2excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This class is purely used as a marker and placed on things that may or may not be thread safe
 * Prefereably this class should be used to mark classes that are known to be non thread safe
 * Used for faster searching of non thread safe things for either fixing and/or just alerting the developer
 *
 * @version 0.1.0
 * @since 0.1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface NonThreadSafe {
}
