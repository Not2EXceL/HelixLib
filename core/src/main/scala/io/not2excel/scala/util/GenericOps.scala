package io.not2excel.scala.util

import scala.reflect.ClassTag

object GenericOps {

    def optionWrap[A: ClassTag](x: A): Option[A] = x match {
        case Some(a: A) => Some(a)
        case a: A => Some(a)
        case _ => None
    }
}

