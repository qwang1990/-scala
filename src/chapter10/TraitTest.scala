package chapter10

import javax.swing.JFrame

/**
  * Created by wangqi on 16/10/24.
  */
//特质中重写抽象方法
trait Logger{
  def log(msg:String)
}


trait TimestampLogger extends Logger{
  abstract override def log(msg:String): Unit ={
    super.log(new java.util.Date()+" "+msg)
  }
}

trait MyLogger extends Logger{
  def log(msg:String) {
    println("hehe")
    println(msg)
  }
}

class Account extends MyLogger with TimestampLogger{
  def SayHello() {log("hello")}
}

//自身类型
trait LoggedException extends Logger{
  this:Exception =>
  def log(msg:String) {log(getMessage)}
}


class Wang(val name:String,val age:Int) {}


object Account extends  App{
  val a = new Account
  a.SayHello()
  //这个是不行的!!!
  //val f = new JFrame with LoggedException
  val q = new Wang("wang",18)
  println(q.name)
}