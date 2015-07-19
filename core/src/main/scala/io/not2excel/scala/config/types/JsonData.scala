package io.not2excel.scala.config.types

/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
class JsonData extends DataType {

    override type T = Any

    override def init(): Unit = ???

    override def get(key: String): Any = ???

    override def get: Option[T] = ???

    override def save(): Unit = ???
}
