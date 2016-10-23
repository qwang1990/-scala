package chapter3
import scala.collection.mutable.ArrayBuffer
//什么时候用的啊....
import scala.collection.JavaConversions.bufferAsJavaList

/**
  * Created by wangqi on 16/10/22.
  */
object ArrayTest extends App{

  //定长数组
  val nums = new Array[Int](10)
  //提供初始值,所以不用news了
  var s = Array("hello","world")

  //不定长数组
  println(nums(1),s(0))

  val b = ArrayBuffer[Int] ()
  b+=1
  b+=(1,2,3,4,5)
  println(b)

  b.trimEnd(3)
  println(b)

////////////////////////////////////////////////
  val a = Array(2,3,4,5,6,11)
  //用数组yield得到的是新数组,用数组缓冲得到的是数组缓冲
  val result = for (elem <- a if elem%2 == 0) yield 2*elem

  println(result.mkString(" and " +
    ""))

  val command = ArrayBuffer("ls","-all","/home/wangqi")
  val pd = new ProcessBuilder(command)  //Scala到java的转换

}
