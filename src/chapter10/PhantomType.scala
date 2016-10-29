package chapter10

/**
  * Created by wangqi on 16/10/28.
  */
class PhantomType {

}

sealed trait ServiceState
final class Started extends ServiceState
final class Stopped extends ServiceState

class Service[State <: ServiceState] private () {
  def start[T >: State <: Stopped]() = this.asInstanceOf[Service[Started]]
  def stop[T >: State <: Started]() = this.asInstanceOf[Service[Stopped]]
}
object Service {
  def create() = new Service[Stopped]
}


object Main extends  App {
   val stopped = Service.create();
   val started =stopped.start();
   started.stop();
}
