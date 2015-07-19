package io.not2excel.scala.config.types

import java.io.{IOException, File}

import org.bukkit.configuration.file.{FileConfiguration, YamlConfiguration}


/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
class YamlData(private val file: File) extends DataType {

    private var config: Option[FileConfiguration] = Option.empty
    override type T = FileConfiguration
    init()

    def this(fileName: String) {
        this(new File(fileName + ".yml"))
    }

    @throws[IOException]
    override def init() = {
        if (!file.exists) {
            file.createNewFile
        }
        config = Option.apply(YamlConfiguration.loadConfiguration(file))
    }

    override def get: Option[T] = config

    override def get(key: String): Any = {
        if (config.isDefined) config.get.get(key)

    }

    @throws[IOException]
    override def save() = if (config.isDefined) config.get.save(file)
}
