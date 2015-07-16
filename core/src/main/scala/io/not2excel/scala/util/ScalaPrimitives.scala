package io.not2excel.scala.util

import scala.collection.immutable.{HashMap, Set}
import scala.runtime._

/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
object ScalaPrimitives {

    private val primitiveToRich = HashMap[Class[_], Class[_]](
        classOf[Boolean] -> classOf[RichBoolean],
        classOf[Byte] -> classOf[RichByte],
        classOf[Char] -> classOf[RichChar],
        classOf[Double] -> classOf[RichDouble],
        classOf[Float] -> classOf[RichFloat],
        classOf[Int] -> classOf[RichInt],
        classOf[Long] -> classOf[RichLong],
        classOf[Short] -> classOf[RichShort],
        classOf[Unit] -> classOf[Void]
    )

    private val richToPrimitive = primitiveToRich.map(_.swap)

    def primitives: Set[Class[_]] = primitiveToRich.keySet

    def wrappers: Set[Class[_]] = richToPrimitive.keySet

    def isPrimitive[T](t: Class[T]): Boolean = primitiveToRich.contains(t)

    def isWrapper[T](t: Class[T]): Boolean = richToPrimitive.contains(t)

    def wrap[T](t: Class[T]): Option[Class[_]] = primitiveToRich.get(t)

    def unwrap[T](t: Class[T]): Option[Class[_]] = richToPrimitive.get(t)
}
