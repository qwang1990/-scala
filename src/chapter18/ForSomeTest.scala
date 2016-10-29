package chapter18

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wangqi on 16/10/29.
  */

class Network{
  class Member(val name:String){
    val contacts = new ArrayBuffer[Member]
  }

  private val members = new ArrayBuffer[Member]

  def join(name :String): Member ={
    val m = new Member(name)
    members += m
    m
  }

}

object Networks extends App{
  def f1[M <: n.Member forSome {val n: Network}](a:M,b:M)=(a,b)
  val chatter = new Network
  val myFace = new Network
  val fred = chatter.join("fred")
  val wilma = chatter.join("wilma")
  val barney = myFace.join("barney")

  f1(fred,wilma)
}
