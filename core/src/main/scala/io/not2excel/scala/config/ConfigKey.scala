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
final class ConfigKey private(private val qualifier: String) {

    def apply(qualifier: String): ConfigKey = new ConfigKey(qualifier)

    def unapply(key: ConfigKey): Tuple1[String] = Tuple1.apply(key.qualifier)

    def as[T: ClassTag, D <: DataType](dataHolder: DataHolder[D]): Option[T] = {
        val value = dataHolder.get(qualifier)
        value match {
            case _: T => Option.apply(value.asInstanceOf[T])
            case _ => Option.empty
        }
    }
}
