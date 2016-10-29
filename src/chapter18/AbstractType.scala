package chapter18

/**
  * Created by wangqi on 16/10/29.
  */

trait Reader{
 type Contents
 def read(filename:String):Contents
}

trait MyReader extends Reader{
 def helloReader():Contents
}

class Hello extends MyReader{
 type Contents = String

 def read(fileName:String) = "hehe"
 def helloReader()="haha"
}

object AbstractType extends App{
 val wang = new Hello
 println(wang.helloReader())
}
