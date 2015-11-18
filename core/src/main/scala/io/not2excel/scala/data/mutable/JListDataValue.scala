package io.not2excel.scala.data.mutable

import java.util

import io.not2excel.scala.data.WrappedDataValueImpl

import scala.language.reflectiveCalls

class JListDataValue[T](private[this] val _wrapped: Option[util.List[T]], val tClass: Class[T])
    extends WrappedDataValueImpl[T, ({type V[B] = util.List[B]})#V](_wrapped, tClass, classOf[util.List[T]])

object JListDataValue {
    def apply[T](value: Option[util.List[T]], c: Class[T]) = {
        new JListDataValue[T](value, c)
    }
}
