package scala.collection.scalatest.mutable

import scala.collection.scalatest.StringBagTest

trait MutableStringBagTest extends StringBagTest with MutableBagBehaviours {

  override def emptyBag: collection.mutable.Bag[String]

  override def bagWithCatCatDogMouseMouseMouse =
    emptyBag + ("Cat" -> 2) + ("Dog" -> 1) + ("Mouse" -> 3)

  it should behave like mutableBagBehaviour[String](bagWithCatCatDogMouseMouseMouse)

}
