package io.not2excel.scala.data

import org.bson.Document

trait DataValue[T] {
    val name = this.getClass.getSimpleName.toLowerCase

    private[data] var _value: Option[T] = None

    def value = _value

    def load(o: Any)

    def deserialize(t: String) = ???

    def serialize = if(_value.isDefined) Some(_value.toString) else None

    def appendTo(document: Document) = {
        val serialized = serialize
        if(serialized.isDefined) {
            document.append(name, serialized.get)
        }
    }

    def print() = {
        val doc: Document = new Document()
        this.appendTo(doc)
        println(doc.toJson)
    }
}

class DataValueImpl[T](private[this] val value: Option[T], val innerClass: Class[T])
    extends DataValue[T] {

    override def load(o: Any) = {
        o.getClass match {
            case `innerClass` => _value = Option(innerClass.cast(o))
            case _ => _value = None
        }
    }
}
