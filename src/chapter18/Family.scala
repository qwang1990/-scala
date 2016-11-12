package chapter18

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wangqi on 16/10/29.
  */
trait Event[S]{
  var source:S = _
}

trait Listener[S,E <: Event[S]]{
  def occurred(e: E):Unit
}

//这里加了自身类型S,this就只能是Event[S]这个了,否则this可能是任意一种resource,其实我觉得也没啥....
trait Source[S,E <: Event[S], L <: Listener[S, E]] {
  this: S=>
  private val listeners = new ArrayBuffer[L]
  def add(l:L) {listeners += l}
  def remove(l:L){listeners -= l}
  def fire(e:E): Unit ={
    //这里this就限制为Event里面的S类型了,
    e.source = this
    for(l <- listeners) l.occurred(e)
  }
}

//我怎么觉得这个这么奇怪呢....好像循环依赖了.
trait ButtonListener extends Listener[Button,ButtonEvent]
class ButtonEvent extends Event[Button]
class Button extends Source[Button,ButtonEvent,ButtonListener]{
  def click(): Unit ={
    //这个时候buttonEvent里的source的类型就是Button了,而不是Object了.
    fire(new ButtonEvent)
  }
}

object Family extends App{

}
