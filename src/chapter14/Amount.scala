package chapter14

/**
  * Created by wangqi on 16/10/27.
  */
abstract class Amount

//object Amount {
//  def apply(value: Double , unit: String): Amount = new Amount(value, unit)
//}

case class Dollar(value : Double) extends Amount

case class Current(value:Double, unit:String) extends Amount

object MainClass extends App{
  val amt : Amount = Current(1.0,"USD")

//  var arr = List(1,2)
//  arr = 1 :: arr

  val value = amt match {
    case Dollar(v)  => "$"+v
    case Current(_,u) => "hahahah zheshige "+u
    case _ => "???"
  }
  println(value)

  val w = Some(100)
  println(w.getOrElse(200))

  //此时q并没有getOrElse方法
  //val q = 100

  var f : PartialFunction[Char,Int] = {case 'x' => 1;case '-' => -1}
  println(f.isDefinedAt('0'))

}