import scala.collection.mutable
import scala.util.hashing.Hashing
import mutable.{BagOfMultiplicitiesBagBucket, TreeBag}

/**
  * Created by Gerard on 10/05/2016.
  */




object QuickTest extends App {
  object StrSize extends Ordering[String] with Hashing[String] {
    def hash(x: String): Int = x.size

    def compare(x: String, y: String): Int = x.size compare y.size
  }

  implicit val config = TreeBag.configuration.compactWithEquiv(StrSize)

  val emptyBag = TreeBag.empty[String]

  val catInBag = emptyBag + "Cat"
  val twoCatsInBag = catInBag + "Cat"
  val twoCatsAndAnEnginePartInBag = twoCatsInBag + "Cam"

  val bag = twoCatsAndAnEnginePartInBag + "Mouse"

  println((bag.bucketsIterator map (_.asInstanceOf[BagOfMultiplicitiesBagBucket[String]].bag.bucketsIterator.toList)).toList)

  println(bag.multiplicities.toList)

}
