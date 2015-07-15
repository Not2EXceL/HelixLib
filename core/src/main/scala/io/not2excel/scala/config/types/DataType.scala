package io.not2excel.scala.config.types

/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
trait DataType {
    type T

    def get: Option[T]
    def get(key: String): Any
    def init()
    def save()
}
