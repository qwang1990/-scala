package Covariance

/**
  * Created by wangqi on 16/10/27.
  */
object Covariance extends App{

  def makeFriends(p: Pair[Person]) = {println("hehe")}
  def makeFriendWith(s: Student,f: Friend[Student]){f.befriend(s)}

  val susan = new Student

  makeFriends(new Pair[Student](susan,susan))

  val fred = new Person
  makeFriendWith(susan,fred)

  //Function1参数是你变得,返回值是斜边的(Function1[-A,+R])
  def friends(students : Array[Student], find: Function1[Student,Person]) = for (s <- students) yield find(s)

  def findStudent(p : Person):Student = {val student = new Student; student}

  //这里可以传入参数findStudent,说明Function1[Person,Student]是Function1[Student,Person]的子类
  friends(Array(new Student),findStudent)
}

class Person extends Friend[Person]
class Student extends Person
//协变
class Pair[+T] (val first : T,val second :T)
//class Pair[+T] (var first : T,var second :T)这样就不行
//报错:Error:(32, 7) covariant type T occurs in contravariant position in type T of value first_=
//因为斜边的可变对偶是不对的,这个时候first_=为逆变

//逆变
trait Friend[-T]{
  def befriend(someone: T) {println("嘿嘿")}
}

//这个就不行,因为T出现了逆变点,在replaceFirst(newFirst:T)这个地方.虽然从功能上来说是没问题的....
//class Pairs[+T](val first:T,val second:T){
//  def replaceFirst(newFirst:T) = new Pairs[T](newFirst,second);
//}
