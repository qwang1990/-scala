package chapter5

/**
  * Created by wangqi on 16/10/23.
  */
object TrafficLightColor extends Enumeration{
  val Red,Yellow,Green = Value

  def doWhat(color : TrafficLightColor.Value) = {
    if (color == Red) "stop"
    else if (color==Yellow) "Hurry up"
    else "go"
  }

  def main(args: Array[String]) {
    for (c <- TrafficLightColor.values) println(c.id+" : "+c)
  }
}


