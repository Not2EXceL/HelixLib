package io.not2excel.scala


import io.not2excel.scala.util.Primitive

import scala.reflect.ClassTag
import scala.runtime.RichDouble

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
        val test = new Test1
//        val ret = mutate[Test1](test)
//        println(test)
//        println(ret)
        println("Primitive to Rich")
        println("=================")
        Primitive.primitiveToRich foreach {
            case(k, v) => println(k + " -> " + v)
        }
        println("=================")
        println("Rich to Primitive")
        println("=================")
        Primitive.richToPrimitive foreach {
            case(k, v) => println(k + " -> " + v)
        }
        println("=================")
        println()
//        println(Primitive.isPrimitive(classOf[Test]))
//        println(Primitive.isPrimitive(classOf[Boolean]))
//        println(Primitive.isPrimitive(classOf[Test1]))
//        println(Primitive.isPrimitive(classOf[Float]))
        println(Primitive.isWrapper(test))
        println(Primitive.isWrapper(new RichDouble(4.5)))
    }

    def mutate[T: ClassTag](m: Any): Any = {
        m match {
            case _: T => m.asInstanceOf[T]
            case _ => null
        }
    }

    trait _Test
    trait _Test_
    class Test extends _Test
    class Test1 extends Test with _Test_
}
