package io.not2excel.scala

import org.bukkit.plugin.java.JavaPlugin

/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
class ScalaLoader extends JavaPlugin {

    override def onLoad() {
        getLogger.info("========== Scala Runtime + Extras ==========")
        getLogger.info("Loaded org.scala-lang.scala-library")
        getLogger.info("Loaded org.scala-lang.scala-reflect")
        getLogger.info("Loaded org.json.json")
        getLogger.info("Loaded org.clapper.grizzled-slf4j_2.11")
        getLogger.info("============================================")
    }
}
