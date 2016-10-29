package chapter18

/**
  * Created by wangqi on 16/10/29.
  */

class sayH{
  def hello(str:String): Unit ={
    println("我就是say hi")
    println(str)
  }
}

class noSayHi;

object StructType extends App{
  //结构类型
  def sayHello(t:{def hello(str:String):Unit},str:String): Unit ={
    t.hello(str)
  }

  val a = new sayH
  val b = new noSayHi

  sayHello(a,"hehehe")

  //这个就不能调用
  //sayHello(b,"heiheihei")

//  type x [Int,String] = (Int,String)
//
//  println(1 Map "wang")
}
