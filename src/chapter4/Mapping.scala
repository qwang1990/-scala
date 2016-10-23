package chapter4

import scala.collection.immutable.HashMap

/**
  * Created by wangqi on 16/10/23.
  */
object Mapping extends App{
  val scores = Map("Alice"->10,"Bob"->3)

  val scores2 = new scala.collection.mutable.HashMap[String,Int]

  //如果是new HashMap就不能调用这个方法..
  scores2("wang")=100
  scores2 += ("bob"->100)

  println(scores2)

  scores2 -= "bob"
  //不会报错,只是没什么用
  scores2 -= "bobs"
  println(scores2)

  //反转一个集合
  val revScore2 = for ((k,v) <- scores2) yield (v,k)
  println(revScore2)
}
