package chapter5

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wangqi on 16/10/23.
  */
class NetWork{
  class Member(val name:String){
    val contacts = new ArrayBuffer[Member]
    val allContacts = new ArrayBuffer[NetWork#Member]
  }

  private val members = new ArrayBuffer[Member]

  def join(name:String) = {
    val m = new Member(name)
    members += m
    m
  }
}

object NetWork extends App{
  //这时chatter.Member和myFace.Member是不同的两个类!
  //所以你可以在各自网络中添加成员,但是不能跨网添加
  val chatter = new NetWork
  val myFace = new NetWork

  val fred = chatter.join("fred")
  val barney = myFace.join("barney")

  //这样就不行!!如果希望这样就要用到类型投影
  //fred.contacts += barney
  fred.allContacts += barney

}
