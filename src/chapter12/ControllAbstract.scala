package chapter12

/**
  * Created by wangqi on 16/10/25.
  */



object ControlAbstract extends App{
  def until(condition: => Boolean)(block: => Unit) {
    if(!condition){
      block
      until(condition)(block)
    }
  }

  var x = 10
  until(x==0){
    x -= 1
    println(x)
  }
}
