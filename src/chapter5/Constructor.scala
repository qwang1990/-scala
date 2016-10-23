package chapter5

/**
  * Created by wangqi on 16/10/23.
  */
class Person{

  println("构造时会执行我,主构造器会执行类定义中全部语句")
  private var name = ""
  private var age = 0

  def this(name:String){
    //调用主构造器
    this()
    this.name = name
  }

  def this(name:String, age:Int){
    this(name)
    this.age = age
  }
}

object Person extends App{
  val person = new Person
}
