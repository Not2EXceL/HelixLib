package io.not2excel.scala.data

import org.bson.Document

trait DefaultDataValue[T] extends DataValue[T] {
    private[data] val _default: Option[T]

    override def appendTo(document: Document) = {
        super.appendTo(document)
        document.append("isDefault", isDefault)
    }

    def isDefault = value.equals(_default)
}
