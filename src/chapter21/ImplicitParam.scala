package chapter21

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wangqi on 16/10/31.
  */


class Pair[T:Ordering](val first:T,val second:T){
  //这样不行....
  //def smaller= if(first<second) first else second

  //1:
  def smaller(implicit ord :Ordering[T])=if(ord.compare(first,second)<0) first else second

  //2:
  def smaller2 =
    if(implicitly[Ordering[T]].compare(first,second)<0) first else second

  //3
  def smaller3 = {
    import Ordered._
    if(first < second) first else second
  }
}


case class Delimiters(left:String,right:String)

object ImplicitParam extends App{
  def quote(what:String)(implicit delims:Delimiters) = delims.left + what +delims.right

  implicit val quoteDelimiters = Delimiters("<<",">>")

  println(quote("wangqi"))

}
