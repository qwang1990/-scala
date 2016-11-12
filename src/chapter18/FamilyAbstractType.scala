package cpt18

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wangqi on 16/10/29.
  */

trait ListenerSupport {
  type S <: Source
  type E <: Event
  type L <: Listener

  trait Event {
    var source:S = _
  }

  trait Listener{
    def occurred(e:E)
  }

  trait Source {
    this: S =>
    private val listeners = new ArrayBuffer[L]
    def add(l:L) {listeners += l}
    def remove(l:L){listeners -= l}
    def fire(e:E): Unit ={
      //这里this就限制为Event里面的S类型了,
      e.source = this
      for(l <- listeners) l.occurred(e)
    }
  }
}

object ButtonModule extends ListenerSupport{
  type S = Button
  type E = ButtonEvent
  type L = ButtonListener

  class ButtonEvent extends Event
  trait ButtonListener extends Listener
  class Button extends Source{
    def click(){fire(new ButtonEvent)}
  }

}


object FamilyAbstractType extends App{
  import ButtonModule._
  val b = new Button
  b.add(new ButtonListener {
    override def occurred(e: ButtonEvent): Unit = {println(e)}
  })
  b.click()
}
