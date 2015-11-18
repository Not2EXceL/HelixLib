package io.not2excel.scala.data

import scala.language.higherKinds

trait WrappedDataValue[U, W[V <: U]] extends DataValue[U]

class WrappedDataValueImpl[U, W[V <: U]](private[this] var _wrapped: Option[W[U]],
                                         val innerClass: Class[U],
                                         val wrappedClass: Class[W[U]])
    extends WrappedDataValue[U, W] {

    def wrapped = _wrapped

    def unwrapOption = {
        if(wrapped.isEmpty)
            null
        else
            wrapped.get
    }

    def wrapped_=(newWrapped: W[U]) = _wrapped = Option(newWrapped)

    def wrapped_=(newWrapped: Option[W[U]]) = _wrapped = newWrapped

    override def load(o: Any) = {
        //still gotta do
    }
}
