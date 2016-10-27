package chapter13

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wangqi on 16/10/25.
  */
object Collection extends App{
  def sum(lst:List[Int]) :Int = lst match {
    case Nil => 0
    case h :: t=>h+sum(t) //h是lst.head 而t是lst.tail
  }

  println(sum(List(1,2,3,4,5)))

  val digits = Set(1,3,5,7,9)
  println(digits contains 0)
  println(Set(1,2) subsetOf digits)


  println(1 +: List(3,4,5))
  println(List(3,4,5) :+ 1)
  println(Set(1,2,3) + (3,4,5))
  println(List(1,2,3) ++: List(3,4,5))
  println(Set(1,2,3) &~ Set(2,3,4))
  println(4 +=: ArrayBuffer(1,2,3))
  println(List(1,2,3) ++ List(2,3,4))

  println("-12".collect{case '+' => 1; case '-' => -1})

  println(List(1,7,2,9).reduceLeft(_ - _))
  println(List(1,7,2,9).foldLeft(1)(_ - _))

  val freq = scala.collection.mutable.Map[Char,Int]()
  for (c <- "Mississppi") freq(c) = freq.getOrElse(c,0) + 1

  println(freq)

  val freq2 = scala.collection.immutable.Map[Char,Int]()
  val f = "Mississppi".foldLeft(freq2)( (m,c) => m + (c->(m.getOrElse(c,0) + 1)))
  println(f)


  println((1 to 10).scanLeft(0)(_ + _))

  println("scala".zipWithIndex)

  println("scala".zipWithIndex.max)


}
