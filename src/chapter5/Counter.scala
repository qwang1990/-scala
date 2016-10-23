package chapter5

/**
  * Created by wangqi on 16/10/23.
  */
class Counter {
  //私有字段,加上一个get属性current
  private var value=10

  //其实就是get/set方法
  def age = value
  def age_= (newValue:Int): Unit ={
    if (newValue > value) value = newValue;
  }


  //默认public
  def increment() {value+=1}

  def current = value

  //方法可以访该类的所有私有字段
  //如果 value定义为: private[this] var value = 0 这样就不行了,它被称为对象私有化,这样counter类的方法只能访问当前对象的value字段
  def isLess(other :Counter) = value < other.value
}

object Counter extends App{
  val myCounter = new Counter
  myCounter.increment()
  println(myCounter.current)

  myCounter.age = 9
  print(myCounter.age)
}
