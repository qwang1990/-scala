package chapter18

/**
  * Created by wangqi on 16/10/28.
  */


class Document{
  def setTitle(title:String):this.type = {println(title);this}
  def setAuthor(author:String) = {println(author);this}

}

class Book extends Document{
  def addChapter(chapter:String) = {println(chapter);this}
}

object TypeMain extends App{
  val a = new Document
  a.setAuthor("wang").setTitle("qi")

  val b = new Book
  //java的例子在上面...
  //一般来说.这样就不行了...,但是setTitle变为this.type就OK了...
  //b.setTitle("wang").addChapter("qi")
  b.setTitle("wang").addChapter("qi")

  //觉得挺傻的,反正TypeMain是单例,直接调用不就行了.
  def set(obj:TypeMain.type)={println("heh")}
}
