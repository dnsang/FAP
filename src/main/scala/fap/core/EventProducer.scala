package fap.core

import scala.concurrent.Future

/**
  * Created by SangDang on 7/13/16.
  */
trait EventProducer {
  def produceSync(event: Event):Boolean
  def produceAsync(event:Event):Future[Boolean]
  def produceAsync(event:Event,numRetries:Int,logIfFailed:Boolean)

}
class BaseEventProducer(pubMediator: PubMediator) extends EventProducer{
  override def produceSync(event: Event): Boolean = ???

  override def produceAsync(event: Event): Future[Boolean] = ???

  override def produceAsync(event: Event, numRetries: Int, logIfFailed: Boolean): Unit = ???
}
