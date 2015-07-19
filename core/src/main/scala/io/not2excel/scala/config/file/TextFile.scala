package io.not2excel.scala.config.file

import java.io._
import java.util.zip.{GZIPOutputStream, GZIPInputStream}

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
class TextFile(file: Option[File], var append: Boolean = false, var compressed: Boolean = false) {

    init()
    private var _lines: List[String] = List.empty
    private val _input: Option[InputStream] = {
        if(file.isDefined && file.get.exists()) {
            var temp: InputStream = new FileInputStream(file.get)
            if(compressed) temp = new GZIPInputStream(temp)
            Option.apply(temp)
        } else {
            Option.empty
        }
    }
    private val _output: Option[OutputStream] = {
        if(file.isDefined && file.get.exists()) {
            var temp: OutputStream = new FileOutputStream(file.get)
            if(compressed) temp = new GZIPOutputStream(temp)
            Option.apply(temp)
        } else {
            Option.empty
        }
    }
    load()

    def lines = _lines

    def init() = if (file.isDefined && !file.get.exists()) file.get.createNewFile()

    def addLine(line: String) = {
        _lines = line :: _lines
        _lines
    }

    def addLines(lines: String*) = {
        _lines = lines.toList.reverse ::: _lines
        _lines
    }

    def flip = {
        _lines.reverse
    }

    @throws[IOException]
    def close(): Unit = {
        close(_input.get)
        close(_output.get)
    }

    @throws[IOException]
    private def close(input: InputStream) = {

    }

    @throws[IOException]
    private def close(output: OutputStream) = {

    }

    def load() = {

    }

    def save() = {

    }

    override def toString: String = {
        var s: String = ""
        _lines.foreach(l => s += (l + "\n"))
        s
    }
}
