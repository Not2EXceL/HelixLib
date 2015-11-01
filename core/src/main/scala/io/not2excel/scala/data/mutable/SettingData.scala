package io.not2excel.scala.data.mutable

import io.not2excel.scala.data.DataValues.DefaultDataValue
import io.not2excel.scala.util.GenericOps

import scala.reflect.ClassTag

sealed class SettingData[T](private val d: Option[T], private val v: Option[T] = None)
    extends MutableDataValueImpl[T](v) with DefaultDataValue[T] {

    override val _default = d
}

object SettingData {

    def apply[T: ClassTag](default: T, value: T = None) = {
        new SettingData(GenericOps.optionWrap(default), GenericOps.optionWrap(value))
    }
}
