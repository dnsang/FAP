package fap.core

/**
  * Created by SangDang on 7/12/16.
  */
trait EventMediator {

  def publish(event: Event)

  def subscribe(eventName: List,eventConsumer: EventConsumer, group: String = null)

  def unsubscribe()
}
