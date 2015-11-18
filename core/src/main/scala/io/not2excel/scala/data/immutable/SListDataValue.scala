package io.not2excel.scala.data.immutable

import io.not2excel.scala.data.WrappedDataValueImpl

import scala.language.reflectiveCalls

class SListDataValue[T](private[this] val _wrapped: Option[List[T]], val tClass: Class[T])
    extends WrappedDataValueImpl[T, ({type V[B] = List[B]})#V](_wrapped, tClass, classOf[List[T]])

object SListDataValue {
    def apply[T](value: Option[List[T]], c: Class[T]) = {
        new SListDataValue[T](value, c)
    }
}
