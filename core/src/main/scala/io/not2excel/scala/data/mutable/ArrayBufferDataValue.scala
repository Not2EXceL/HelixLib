package io.not2excel.scala.data.mutable

import io.not2excel.scala.data.WrappedDataValueImpl

import scala.collection.mutable.ArrayBuffer
import scala.language.reflectiveCalls

class ArrayBufferDataValue[T](private[this] val _wrapped: Option[ArrayBuffer[T]], val tClass: Class[T])
    extends WrappedDataValueImpl[T, ({type V[B] = ArrayBuffer[B]})#V](_wrapped, tClass, classOf[ArrayBuffer[T]])

object ArrayBufferDataValue {
    def apply[T](value: Option[ArrayBuffer[T]], c: Class[T]) = {
        new ArrayBufferDataValue[T](value, c)
    }
}
