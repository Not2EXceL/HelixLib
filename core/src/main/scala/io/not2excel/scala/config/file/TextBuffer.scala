package io.not2excel.scala.config.file

import java.io._
import java.util.zip.{GZIPInputStream, GZIPOutputStream}

/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
/**
 * This class represents a simple text file on disk
 *
 * Everything is prepended to increase performance (constant time vs linear time from appending)
 * flip needs to be called if appending was the desired effect
 *
 * @param file text file
 * @param compressed compress the output with gzip or not
 */
class TextBuffer(file: Option[File], var append: Boolean = false, var compressed: Boolean = false) {

    init()
    private var _lines: List[String] = List.empty
    private val _input: Option[InputStream] = {
        if (file.isDefined && file.get.exists()) {
            var temp: InputStream = new FileInputStream(file.get)
            if (compressed) temp = new GZIPInputStream(temp)
            Option.apply(temp)
        } else Option.empty
    }
    private val _output: Option[OutputStream] = {
        if (file.isDefined && file.get.exists()) {
            var temp: OutputStream = new FileOutputStream(file.get)
            if (compressed) temp = new GZIPOutputStream(temp)
            Option.apply(temp)
        } else Option.empty
    }
    load()

    def lines = _lines

    def reverse = _lines.reverse

    def flip() = _lines = _lines.reverse

    def init() = if (file.isDefined && !file.get.exists()) file.get.createNewFile()

    def addLine(line: String) = {
        _lines = line :: _lines
    }

    def addLines(lines: String*) = {
        _lines = lines.toList.reverse ::: _lines
    }


    @throws[IOException]
    def close(): Unit = {
        close(_input)
        close(_output)
    }

    @throws[IOException]
    private def close[T <: Closeable](closeable: Option[T]) = if (closeable.isDefined) closeable.get.close()

    def load() = {

    }

    def save() = {

    }

    override def toString = _lines.reduce(_ + "\n" + _)
}
