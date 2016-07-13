package fap.core

import scala.concurrent.Future

/**
  * Created by SangDang on 7/12/16.
  */
trait PubMediator {
  def publish(event: Event)
  def publishAsync(event: Event):Future[Boolean]
  def publishSync(event:Event):Boolean

}
trait SubMediator{
  val group:String
  val names:Set[String]
  def pull(timeout:Long):Iterable[Event]
  def commitSync()
  def commitAsync()
}
