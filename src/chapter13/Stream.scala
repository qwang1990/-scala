package chapter13

import scala.io.Source
import scala.math.pow
import scala.collection.JavaConversions.propertiesAsScalaMap

/**
  * Created by wangqi on 16/10/26.
  */
object Stream extends App{

  def numsFrom(n:BigInt) : Stream[BigInt] = n #:: numsFrom(n + 1)

  val squares = numsFrom(1).map(x => x * x)

  println(squares.take(5).force)

  val words = Source.fromFile("Stream.scala").getLines().toStream

  //stream缓存访问过的行,允许重新访问他们
  println(words)
  println(words(3))
  println(words)

  val powers = (0 until 1000).view.map(pow(10,_))
  println(powers(100))

  val props : scala.collection.mutable.Map[String,String] = System.getProperties()
  println(props)

  for (i <- (0 until 100).par) print(i + " ")
  println()
  println(for (i <- (0 until 100).par) yield i + " ")

  var count = 0

  for (c <- (0 until 100).par) {if (c%2 == 0) count += 1}

  println(count)


}
