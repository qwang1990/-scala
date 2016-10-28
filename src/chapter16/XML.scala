package chapter16

import scala.xml.{NodeBuffer, NodeSeq}

/**
  * Created by wangqi on 16/10/27.
  */
object XML extends App{

  val elem = <a href="www.baidu.com">The <em>Scala</em> language</a>

  for (n <- elem.child) println(n)

  val items = new NodeBuffer
  items += <li>Fred<wang>hehe</wang></li>
  items += <li>Wilma<wang>heihei</wang></li>
  val nodes : NodeSeq = items

  for (n <- nodes) println(n)
}
