package chapter4

/**
  * Created by wangqi on 16/10/23.
  */
object Tuple extends App{
  val t =(1,3.15,"wang")

  println(t._3)

  val symbol = Array("<","-",">")
  val counts = Array(2,10,2)
  //(),(),()的array
  val pairs = symbol.zip(counts)

  println(pairs.mkString(" "))

  //可转换为map
  val pairMap = pairs.toMap
  println(pairMap)

  for ((s,n) <- pairs) Console.print(s*n)
}
