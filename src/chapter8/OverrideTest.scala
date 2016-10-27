package chapter8

/**
  * Created by wangqi on 16/10/23.
  */
class Person(val name : String){
  override def toString = getClass.getName + "name = "+name
}

class SecretAgent(codename:String) extends Person(codename){
  override val name = "secret"
  override val toString = "secret"
}

object MainObject extends App{
  val a = new SecretAgent("wang")
  println(a)
  println(a.name)

  val b = new Person("wang")
  println(b)
  println(b.name)

}
