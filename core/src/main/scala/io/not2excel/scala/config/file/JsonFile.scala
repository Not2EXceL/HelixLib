package io.not2excel.scala.config.file

import java.io.File

import org.json.JSONObject


/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
class JsonFile(file: File, var jsonObject: JSONObject = new JSONObject(),
               var compressed: Boolean = false) {

    load()

    def this(fileName: String) {
        this(new File(fileName + (if(fileName.endsWith(".yml")) "" else ".json")))
    }

    def load() = {

    }

    def save(): Unit = {
        save(4)
    }

    def save(indent: Int) = {

        val json = jsonObject.toString(indent)


//        TextFile text = new TextFile(file, false, compressed);
//        text.addLine(string);
//        text.save();
    }
}
