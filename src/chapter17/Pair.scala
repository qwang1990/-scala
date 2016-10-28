package chapter17

/**
  * Created by wangqi on 16/10/27.
  */
//添加一个上界,T必须为comparable的子类
class Pair[T <% Comparable[T] ](val first:T,val second :T) {
  Int
}

object Main extends App{
  val p = new Pair(1,2)

  def makePair[T :Manifest] (first :T,second:T) = {
    val r =new Array[T](2)
    r(0) = first
    r(1) = second
    r
  }

  val wang = makePair("wang","qi")
  println(wang.mkString)

//def firstLast[A,C <: Iterable[A]] (it :C) = (it.head,it.last)这样就不行...
//因为它是在同一个步骤中匹配到A和C的
// Error:(27, 12) inferred type arguments [Nothing,List[Int]] do not conform to method firstLast's type parameter bounds [A,C <: Iterable[A]]
  def firstLast[A,C] (it :C) (implicit ev: C<:<Iterable[A]) = (it.head,it.last)

  val hl = firstLast(List(1,2,3))

  println(hl)

}