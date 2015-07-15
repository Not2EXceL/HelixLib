package io.not2excel.scala

import scala.reflect.ClassTag

/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
object Main {

    def main(args: Array[String]) = {
        val test: Tuple1[Any] = Tuple1[Any](14)
        val ret = mutate(classOf[Integer], test._1)
        println(ret)
    }

    def mutate[T: ClassTag](tClass: Class[T], m: Any): Any = {
        m match {
            case _: T => tClass.cast(m)
            case _ => m
        }
    }
}
