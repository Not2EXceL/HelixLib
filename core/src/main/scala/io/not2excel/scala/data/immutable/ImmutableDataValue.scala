package io.not2excel.scala.data.immutable

import io.not2excel.scala.data.DataValues.DataValue
import io.not2excel.scala.util.GenericOps

import scala.reflect.ClassTag


trait ImmutableDataValue[T, C] extends DataValue[T] {
    private[data] var _const: Option[C] = None

    def const = _const

    def serializeConst = if(_const.isDefined) Some(_const.toString) else None

    def deserializeConst(t: String) = this
}

class ImmutableDataValueImpl[T, C](private[this] val value: Option[T],
                                   private[this] val const: Option[C] = None)
    extends ImmutableDataValue[T, C] {
    _value = value
    _const = const
}

object ImmutableDataValue {

    def apply[T: ClassTag, C: ClassTag](value: T, const: C) = {
        new ImmutableDataValueImpl(GenericOps.optionWrap(value), GenericOps.optionWrap(const))
    }
}
