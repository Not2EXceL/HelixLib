package io.not2excel.scala.data

object DataValues {

    trait DataValue[T] {
        val name = this.getClass.getSimpleName.toLowerCase

        private[data] var _value: Option[T] = None

        def value = _value

        def deserialize(t: String) = this

        def serialize = if(_value.isDefined) Some(_value.toString) else None

    }

    trait DefaultDataValue[T] extends DataValue[T] {
        private[data] val _default: Option[T]

        def isDefault = value.equals(_default)
    }

}
