package fap.core

/**
  * Created by SangDang on 7/13/16.
  */
trait EventProducer {
  val eventMediator:EventMediator
  def produce(event: Event)={
    eventMediator.publish(event)
  }
}
