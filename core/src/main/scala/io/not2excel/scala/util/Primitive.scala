package io.not2excel.scala.util

import scala.collection.immutable.HashMap
import scala.runtime._

/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
object Primitive {

    val primitiveToRich = HashMap(
        classOf[Boolean] -> classOf[RichBoolean],
        classOf[Byte] -> classOf[RichByte],
        classOf[Char] -> classOf[RichChar],
        classOf[Double] -> classOf[RichDouble],
        classOf[Float] -> classOf[RichFloat],
        classOf[Int] -> classOf[RichInt],
        classOf[Long] -> classOf[RichLong],
        classOf[Short] -> classOf[RichShort]
    )

    val richToPrimitive = primitiveToRich.map(_.swap)

    def isPrimitive[T](t: Class[T]): Boolean = {
        t match {
            case x if x == classOf[Boolean] => true
            case x if x == classOf[Byte] => true
            case x if x == classOf[Char] => true
            case x if x == classOf[Double] => true
            case x if x == classOf[Float] => true
            case x if x == classOf[Int] => true
            case x if x == classOf[Long] => true
            case x if x == classOf[Short] => true
            case _ => false
        }
    }

    def isPrimitive[T](t: T): Boolean = {
        t match {
            case _: Boolean => true
            case _: Byte => true
            case _: Char => true
            case _: Double => true
            case _: Float => true
            case _: Int => true
            case _: Long => true
            case _: Short => true
            case _ => false
        }
    }

    def isWrapper[T](t: Class[T]): Boolean = {
        t match {
            case x if x == classOf[RichBoolean] => true
            case x if x == classOf[RichByte] => true
            case x if x == classOf[RichChar] => true
            case x if x == classOf[RichDouble] => true
            case x if x == classOf[RichFloat] => true
            case x if x == classOf[RichInt] => true
            case x if x == classOf[RichLong] => true
            case x if x == classOf[RichShort] => true
            case _ => false
        }
    }

    def isWrapper[T](t: T): Boolean = {
        t match {
            case _: RichBoolean => true
            case _: RichByte => true
            case _: RichChar => true
            case _: RichDouble => true
            case _: RichFloat => true
            case _: RichInt => true
            case _: RichLong => true
            case _: RichShort => true
            case _ => false
        }
    }
}
