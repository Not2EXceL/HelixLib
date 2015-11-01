package io.not2excel.scala.data.mutable

import io.not2excel.scala.data.DataValues.DataValue
import io.not2excel.scala.util.GenericOps

import scala.reflect.ClassTag

trait MutableDataValue[T] extends DataValue[T] {

    def value_=(value: T)(implicit tTag: ClassTag[T]) = _value = GenericOps.optionWrap(value)
}

class MutableDataValueImpl[T](private[this] override var value: Option[T]) extends MutableDataValue[T] {
    _value = value
}

object MutableDataValue {

    def apply[T: ClassTag](value: T) = {
        new MutableDataValueImpl(GenericOps.optionWrap(value))
    }
}

