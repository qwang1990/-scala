package FutureAndPromise

/**
  * Created by wangqi on 16/11/3.
  */
import scala.concurrent._
import ExecutionContext.Implicits.global

object Mian extends App {

  val firstOccurrence: Future[Int] = Future {
    val source = scala.io.Source.fromFile("myText.txt")
    source.toSeq.indexOfSlice("myKeyword")
  }
  firstOccurrence onSuccess {
    case idx => println("The keyword first appears at position: " + idx)
  }
  firstOccurrence onFailure {
    case t => println("Could not process file: " + t.getMessage)
  }


  @volatile var totalA = 0
  val text = Future {
    "na" * 16 + "BATMAN!!!"
  }
  text onSuccess {
    case txt => totalA += txt.count(_ == 'a')
  }
  text onSuccess {
    case txt => totalA += txt.count(_ == 'a')
  }



  Thread.sleep(1000)
  println(totalA)

//  val a =2/0
//
//  println(a)



}

