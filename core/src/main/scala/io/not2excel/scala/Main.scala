package io.not2excel.scala


import java.io.File

import io.not2excel.scala.config.file.TextBuffer
import io.not2excel.scala.config.types.YamlData
import io.not2excel.scala.util.ScalaPrimitives

import scala.reflect.ClassTag
import scala.runtime.{RichInt, RichShort, RichFloat, RichDouble}

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
        val tDir = new File("test")
        tDir.mkdir()

        val test: Any = new Test1
        val ret = mutate[_Test_](test)
        println(test.getClass)
        println(ret.getClass)
        println(ScalaPrimitives.unwrap(classOf[RichShort]))
        println(ScalaPrimitives.wrap(classOf[Boolean]))
        println(ScalaPrimitives.unwrap(classOf[RichInt]))
        println(ScalaPrimitives.wrap(classOf[Test]))
        println(ScalaPrimitives.wrap(null))
        val file = new File(tDir, "test.yml")
        println(file.getAbsolutePath)
        val yaml = new YamlData(file)
        println(yaml.get.isDefined)

        val t: TextBuffer = new TextBuffer(Option.empty)
        println(t.lines)
        t.addLines("line 1", "line 2")
        t.addLine("line 3")
        t.addLines("line 4", "line 5")
        t.addLine("line 6")
        println(t.lines)
        println(t)
        t.flip()
        println(t.lines)
        println(t)

        val s = "asdf;"
        println(s)
        println(s.substring(0, s.length - 1))
        println(s.substring(0, s.length - 2))
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
