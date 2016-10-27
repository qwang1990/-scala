package chapter12

/**
  * Created by wangqi on 16/10/24.
  */
object FunctionTest extends App {
  println((1 to 9).map(0.1*_))

  (1 to 9).map("*" * _).foreach(println _)
}
