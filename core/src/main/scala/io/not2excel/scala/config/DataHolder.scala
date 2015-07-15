package io.not2excel.scala.config

import io.not2excel.scala.config.types.DataType

import scala.reflect.ClassTag

/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
class DataHolder[D <: DataType](data: D) {

    private[config] def get(key: String): Any = {
        data.get(key)
    }

    def getAs[T: ClassTag](key: ConfigKey): Option[T] = {
        key.as[T, D](this)
    }
}
