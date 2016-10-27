package chapter14

/**
  * Created by wangqi on 16/10/27.
  */
object SwitchMatch extends App{

 val ch = '2'

 //添加守护
 var value = ch match {
  case '+' => 1
  case '-' => -1
  case _ if Character.isDigit(ch) => Character.digit(ch,10)
  case _ => 0
 }

 println(value)


 val i = '2'

 i match {
  case '+' => 1
  case '-' => -1
  case wang => value = Character.digit(wang,2)
 }

 println(ch)

 println(value)

 val pattern = "([0-9]+) ([a-z]+)".r

 "99 bottles" match {
  case pattern(num,item) => println(item)
 }

 val (q,r) = BigInt(10) /% 3
 println(q,r)
}

